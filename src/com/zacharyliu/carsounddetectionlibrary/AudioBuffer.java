package com.zacharyliu.carsounddetectionlibrary;

import java.util.ArrayList;
import java.util.List;

public class AudioBuffer {
	private List<Integer> data;
	private int step;
	private int overlap_sample_length;
	private int fft_sample_length;

	public AudioBuffer(int fft_sample_length, int overlap_sample_length) {
		this.data = new ArrayList<Integer>();
		this.fft_sample_length = fft_sample_length;
		this.overlap_sample_length = overlap_sample_length;
		this.step = fft_sample_length - overlap_sample_length;
	}
	
	public void push(List<Integer> samples) {
		data.addAll(samples);
	}
	
	public boolean available() {
		return this.data.size() >= this.fft_sample_length;
	}
	
	public List<Integer> read() {
		List<Integer> output = this.data.subList(0, this.fft_sample_length);
		this.data = this.data.subList(this.step, this.data.size());
		return output;
	}
}
