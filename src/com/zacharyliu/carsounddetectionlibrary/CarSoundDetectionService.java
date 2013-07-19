package com.zacharyliu.carsounddetectionlibrary;

import java.util.List;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Binder;
import android.os.IBinder;

import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVector;
import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVectorExtractor;
import com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers.Classifier;
import com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers.NeuralNetworkClassifier;

public class CarSoundDetectionService extends Service {
	
	private CarSoundDetectionReceiver mReceiver;
	public Activity mActivity;
	public AnalyzerThread mAnalyzer;
	private static final int RECORDER_SAMPLERATE = 44100;
//	private static final int RECORDER_SAMPLERATE = 16000;
	private static final int RECORDER_CHANNELS = AudioFormat.CHANNEL_IN_MONO;
	private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;
	private static final int BUFFER_SIZE = 5 * AudioRecord.getMinBufferSize(RECORDER_SAMPLERATE, RECORDER_CHANNELS, RECORDER_AUDIO_ENCODING);
	
//	private static final int SHORT_16BIT_CONSTANT = 32768; // 2^(16-1) for signed 16-bit short
	
//	private int numRun = 1;
	
	public class CarSoundDetectionBinder extends Binder {		
		public void start(Activity activity, CarSoundDetectionReceiver receiver) {
			mActivity = activity;
			mReceiver = receiver;
			mAnalyzer = new AnalyzerThread();
			mAnalyzer.start();
		}
		
		public void stop() {
			// Stop and remove the thread
			mAnalyzer.end();
			mAnalyzer = null;
		}
	}
	private CarSoundDetectionBinder mBinder = new CarSoundDetectionBinder();
	
	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}
	
	public String getString() {
		return "Service Started";
	}
	
	class AnalyzerThread extends Thread {
		private Classifier classifier;
		private FeatureVectorExtractor extractor = new FeatureVectorExtractor(RECORDER_SAMPLERATE);
//		private DataBuffer<Double> buffer = new DataBuffer<Double>(100);
		short[] raw_buffer = new short[BUFFER_SIZE];
		int[] buffer;
		private AudioRecord recorder;
		private boolean isRunning = false;
//		private long start;
		
		private List<FeatureVector> push(int[] buffer) {
			List<FeatureVector> vectors = extractor.push(buffer);
			int length = vectors.size();
			
			// Initialize classifier if necessary
			if (classifier == null && vectors.size() > 0) {
				classifier = new NeuralNetworkClassifier(vectors.get(0).size(), 2); // TODO: Find way to specify number of outputs
			}
			
			for (int i=0; i<length; i++) {
				FeatureVector vector = vectors.get(i);
//				Log.d("Vector!", vector.toString());
				vector.classify(classifier);
			}
			return vectors;
		}
		
		@Override
		public void run() {
			isRunning = true;
			recorder = new AudioRecord(MediaRecorder.AudioSource.MIC, RECORDER_SAMPLERATE, RECORDER_CHANNELS, RECORDER_AUDIO_ENCODING, BUFFER_SIZE);
			recorder.startRecording();
			while (isRunning) {
//				if (numRun == 5) {
//					Debug.startMethodTracing("AnalyzerTrace", 50000000);
//					Log.d("TRACE", "Now tracing");
//				}
//				start = android.os.SystemClock.uptimeMillis();
				readBuffer();
//				Log.d("Read Time", Long.toString(android.os.SystemClock.uptimeMillis() - start));
//				start = android.os.SystemClock.uptimeMillis();
				buffer = convertBuffer(raw_buffer);
				List<FeatureVector> vectors = push(buffer);
//				Log.d("Analyze Time", Long.toString(android.os.SystemClock.uptimeMillis() - start));
				for (final FeatureVector vector : vectors) {
					mActivity.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							mReceiver.onResult(vector);
						}
					});
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				if (numRun == 5) {
//					Debug.stopMethodTracing();
//				}
//				numRun++;
			}
		}
		
		private void readBuffer() {
			int amountRead;
			int offset = 0;
			int remaining = BUFFER_SIZE;
			while (remaining > 0) {
				amountRead = recorder.read(raw_buffer, offset, remaining);
				remaining -= amountRead;
				offset += amountRead;
			}
		}
		
		private int[] convertBuffer(short[] buffer) {
			int[] output = new int[buffer.length];
			for (int i=0; i<buffer.length; i++) {
//				output[i] = (int) ((double) buffer[i] / SHORT_16BIT_CONSTANT);
				output[i] = (int) buffer[i];
			}
//			Log.v("Buffer", Arrays.toString(output));
			return output;
		}
		
		public void end() {
			isRunning = false;
			recorder.stop();
			recorder.release();
		}
	}
	
}
