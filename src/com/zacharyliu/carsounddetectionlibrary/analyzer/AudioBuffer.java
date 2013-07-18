package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.LinkedList;
import java.util.Queue;

public class AudioBuffer {
	private Queue<Integer> data;
//	private int step;
//	private int overlap_sample_length;
	private int fft_sample_length;

	public AudioBuffer(int fft_sample_length, int overlap_sample_length) {
		this.data = new LinkedList<Integer>();
		this.fft_sample_length = fft_sample_length;
//		this.overlap_sample_length = overlap_sample_length;
//		this.step = fft_sample_length - overlap_sample_length;
	}
	
	public void push(int[] samples) {
		for (int i=0; i<samples.length; i++) {
			data.add(samples[i]);
		}
	}
	
	public boolean available() {
		return this.data.size() >= fft_sample_length;
	}
	
	public int[] read() {
		int[] output = new int[fft_sample_length];
		for (int i=0; i<fft_sample_length; i++) {
			output[i] = data.remove();
		}
		return output;
	}
}
