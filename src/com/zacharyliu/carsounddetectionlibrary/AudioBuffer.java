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
	
	public void push_samples(List<Integer> samples) {
		this.data.addAll(samples);
	}
	
	public List<Integer> pop_working_set() {
		int length = this.data.size();
		if (length < this.fft_sample_length) {
			return null;
		} else {
			int count = (length - this.fft_sample_length) / this.step;
			int output_length = this.fft_sample_length + count * this.step;
			List<Integer> output = this.data.subList(0, output_length + 1);
			this.data = this.data.subList(output_length + 1, this.data.size());
			return output;
		}
	}
}
