package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.util.Log;
import edu.emory.mathcs.jtransforms.fft.DoubleFFT_1D;

public class FFT {
	private int rate;
	private int fft_sample_length;
//	private int overlap_sample_length;
//	private int step;
	private int numFreqs;
	private double[] windowVals;
	public List<Double> freqs;
	private DoubleFFT_1D fft;
	private double windowValsScalar;

	public FFT(int rate) {
		this.rate = rate;
		
		FFTSizeCalculator calculator = new FFTSizeCalculator(rate);
		this.fft_sample_length = calculator.fft_sample_length;
//		this.overlap_sample_length = calculator.overlap_sample_length;
//		this.step = calculator.step;
		
		this.numFreqs = this.fft_sample_length / 2 + 1;
		
		this.windowVals = new double[this.fft_sample_length];
		this.windowValsScalar = 0.0;
		for (int i=0; i<this.fft_sample_length; i++) {
			windowVals[i] = hamming_scalar(fft_sample_length, i);
			windowValsScalar += Math.pow(windowVals[i], 2);
		}
		Log.d("windowVals", Arrays.toString(windowVals));
		
		this.freqs = new ArrayList<Double>();
		double scalar = ((double) this.rate) / this.fft_sample_length;
		for (int i=0; i<this.numFreqs; i++) {
			 this.freqs.add(scalar * i);
		}
		
		this.fft = new DoubleFFT_1D(fft_sample_length);
	}
	
	public Slice run(int[] data) {
		double[] x = new double[data.length];
		for (int i=0; i<data.length; i++) {
			x[i] = (data[i] * windowVals[i]);
		}
		
		fft.realForward(x);
		
		double[] output = new double[numFreqs];
		int loops = fft_sample_length / 2;
		for (int k=0; k<loops; k++) {
			double real = x[2*k];
			double imag = x[2*k+1];
			output[k] = Math.pow(real, 2) + Math.pow(imag, 2); // Get square of magnitude of complex vector
		}
		output[output.length-1] = x[x.length-1]; // (n/2) frequency component is purely real
		
		// Scaling and normalizing output
		double scalar = windowValsScalar * rate;
		for (int i=0; i<output.length; i++) {
			output[i] = output[i] / scalar;
			if (i != 0 && i != output.length-1) {
				output[i] *= 2.0;
			}
		}
		
		return new Slice(output);
	}
	
	private double hamming_scalar(int total, int n) {
		return 0.5 * (1.0 - Math.cos(2.0 * Math.PI * n / (total - 1.0)));
	}
}
