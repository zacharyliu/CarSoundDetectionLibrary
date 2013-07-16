package com.zacharyliu.carsounddetectionlibrary;

import java.util.ArrayList;
import java.util.List;

public class FFT {
	private int rate;
	private int fft_sample_length;
	private int overlap_sample_length;
	private Object step;
	private int numFreqs;
	private double[] windowVals;
	public List<Double> freqs;

	public FFT(int rate) {
		this.rate = rate;
		
		FFTSizeCalculator calculator = new FFTSizeCalculator(rate);
		this.fft_sample_length = calculator.fft_sample_length;
		this.overlap_sample_length = calculator.overlap_sample_length;
		this.step = calculator.step;
		
		this.numFreqs = this.fft_sample_length / 2 + 1;
		this.windowVals = hanning(this.fft_sample_length); // TODO: Hanning window in library
		this.freqs = new ArrayList<Double>();
		double scalar = this.rate / this.fft_sample_length;
		for (int i=0; i<this.numFreqs; i++) {
			 this.freqs.add(scalar * i);
		}
	}
	
	public Slice run(List<Integer> x) {
		List<Double> windowed_x = new ArrayList<Double>(x.size());
		for (int i=0; i<x.size(); i++) {
			windowed_x.add(x.get(i) * this.windowVals[i]);
		}
		List<Double> fx = fft(windowed_x, this.fft_sample_length);
		
		// TODO: FFT library and implementation in code
		
		return (Slice) fx;
	}
}
