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
	public int[] freqs;

	public FFT(int rate) {
		this.rate = rate;
		
		FFTSizeCalculator calculator = new FFTSizeCalculator(rate);
		this.fft_sample_length = calculator.fft_sample_length;
		this.overlap_sample_length = calculator.overlap_sample_length;
		this.step = calculator.step;
		
		this.numFreqs = this.fft_sample_length / 2 + 1;
		this.windowVals = hanning(this.fft_sample_length); // TODO: Hanning window in library
		this.freqs = new ArrayList<Integer>();
		double scalar = this.rate / this.fft_sample_length;
		for (int i=0; i<this.numFreqs; i++) {
			 this.freqs.add(scalar * i);
		}
	}
	
	public double[] run(int[] x) {
		double[] windowed_x = new double[x.length];
		for (int i=0; i<x.length; i++) {
			windowed_x[i] = x[i] * this.windowVals[i];
		}
		double[] fx = fft(windowed_x, this.fft_sample_length);
		
		// TODO: FFT library and implementation in code
		
		return fx;
	}
}
