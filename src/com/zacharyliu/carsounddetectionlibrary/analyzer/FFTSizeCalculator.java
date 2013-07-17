package com.zacharyliu.carsounddetectionlibrary.analyzer;

public class FFTSizeCalculator {
	private static final int FRAME_TIME_LENGTH = 180;
	public int rate;
	public int fft_sample_length;
	public int overlap_sample_length;
	public int step;

	public FFTSizeCalculator(int rate) {
		this.rate = rate;
		int frame_samples_length = FRAME_TIME_LENGTH / 1000 * this.rate;
		this.fft_sample_length = (int) Math.pow(2, nextpow2(frame_samples_length));
		this.overlap_sample_length = (int) 0.3 * frame_samples_length;
		this.step = this.fft_sample_length - this.overlap_sample_length; 
	}
	
	private int nextpow2(int num) {
		return (int) Math.ceil(Math.log(num) / Math.log(2));
	}
}
