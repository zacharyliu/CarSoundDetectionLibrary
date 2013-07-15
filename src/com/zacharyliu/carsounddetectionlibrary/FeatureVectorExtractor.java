package com.zacharyliu.carsounddetectionlibrary;

import java.util.HashMap;
import java.util.Map;

public class FeatureVectorExtractor {
	private int rate;
	private final int FRAME_TIME_LENGTH = 180;
	private int fft_sample_length;
	private int overlap_sample_length;
	private AudioBuffer audio_buffer;
	private Map<String, DataBuffer<?>> buffers;
	private FeatureVectorBuffer classifier;
	
	public FeatureVectorExtractor(int rate) {
		this.rate = rate;
		int frame_samples_length = (int) ((float) FRAME_TIME_LENGTH / 1000 * this.rate);
		this.fft_sample_length = (int) Math.pow(2, nextpow2(frame_samples_length));
		this.overlap_sample_length = (int) 0.3 * frame_samples_length;
		this.audio_buffer = new AudioBuffer(this.fft_sample_length, this.overlap_sample_length);
		this.buffers = new HashMap<String, DataBuffer<?>>();
		// TODO: initialize buffers
		this.classifier = new FeatureVectorBuffer();
	}
	
	private int nextpow2(int num) {
		return (int) Math.ceil(Math.log(num) / Math.log(2));
	}
}
