package com.zacharyliu.carsounddetectionlibrary;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Binder;
import android.os.IBinder;

import com.zacharyliu.carsounddetectionlibrary.CarSoundDetectionService.AnalyzerThread;
import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVector;
import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVectorExtractor;
import com.zacharyliu.carsounddetectionlibrary.analyzer.Result;
import com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers.Classifier;
import com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers.NeuralNetworkClassifier;

public class CarSoundDetectionService extends Service {
	
	private CarSoundDetectionReceiver mReceiver;
	public Activity mActivity;
	public AnalyzerThread mAnalyzer;
	private static final int RECORDER_SAMPLERATE = 44100;
	private static final int RECORDER_CHANNELS = AudioFormat.CHANNEL_IN_MONO;
	private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;
	private static final int BUFFER_SIZE = AudioRecord.getMinBufferSize(RECORDER_SAMPLERATE, RECORDER_CHANNELS, RECORDER_AUDIO_ENCODING);
	
	private static final int SHORT_16BIT_CONSTANT = 32768; // 2^(16-1) for signed 16-bit short
	
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
		private Classifier classifier = new NeuralNetworkClassifier();
		private FeatureVectorExtractor extractor = new FeatureVectorExtractor(RECORDER_SAMPLERATE);
//		private DataBuffer<Double> buffer = new DataBuffer<Double>(100);
		short[] raw_buffer = new short[BUFFER_SIZE];
		List<Integer> buffer;
		List<Result> results = new ArrayList<Result>();
		private AudioRecord recorder;
		private boolean isRunning = false;
		
		private List<Result> push(List<Integer> samples) {
			List<FeatureVector> feature_vectors = extractor.push(samples);
			List<Result> results = new ArrayList<Result>();
			for (FeatureVector vector : feature_vectors) {
				Result result = classifier.run(vector);
				results.add(result);
			}
			return results;
		}
		
		@Override
		public void run() {
			isRunning = true;
			recorder = new AudioRecord(MediaRecorder.AudioSource.MIC, RECORDER_SAMPLERATE, RECORDER_CHANNELS, RECORDER_AUDIO_ENCODING, BUFFER_SIZE);
			while (isRunning) {
				recorder.read(raw_buffer, 0, BUFFER_SIZE);
				buffer = convertBuffer(raw_buffer);
				results = push(buffer);
				for (final Result result : results) {
					mActivity.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							mReceiver.onResult(result);
						}
					});
				}
			}
		}
		
		private List<Integer> convertBuffer(short[] buffer) {
			List<Integer> output = new ArrayList<Integer>(buffer.length);
			for (short i : buffer) {
				output.add((int) ((double) i / SHORT_16BIT_CONSTANT));
			}
			return output;
		}
		
		public void end() {
			isRunning = false;
			recorder.release();
		}
	}
	
}
