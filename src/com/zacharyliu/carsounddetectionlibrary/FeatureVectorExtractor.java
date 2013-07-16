package com.zacharyliu.carsounddetectionlibrary;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FeatureVectorExtractor {
	private static final int[] DIVISIONS = {500, 1000, 2500, 5000, 7000};
	private static final int MOVING_AVERAGE_LENGTH = 3; // length in number of FFT intervals
	private static final int MOVING_THRESHOLD_LENGTH = 70;
	private int rate;
	private final int FRAME_TIME_LENGTH = 180;
	private int fft_sample_length;
	private int overlap_sample_length;
	private AudioBuffer audio_buffer;
	private Map<String, DataBuffer<?>> buffers;
	private FeatureVectorBuffer classifier;
	private FFT fft;
	private int[] original_freqs;
	private int[] freqs;
	private int[] bin_divisions_indexes;
	
	public FeatureVectorExtractor(int rate) {
		this.rate = rate;
		FFTSizeCalculator calculator = new FFTSizeCalculator(rate);
		this.fft_sample_length = calculator.fft_sample_length;
		this.overlap_sample_length = calculator.overlap_sample_length;
		this.audio_buffer = new AudioBuffer(this.fft_sample_length, this.overlap_sample_length);
		this.buffers = new HashMap<String, DataBuffer<?>>();
		// TODO: initialize buffers
		this.classifier = new FeatureVectorBuffer();
		this.fft = new FFT(this.rate);
		this.original_freqs = this.fft.freqs;
		this.freqs = this.high_pass_filter_freqs(this.original_freqs, 500);
		this.bin_divisions_indexes = this.find_indexes(this.freqs, DIVISIONS);
	}
	
	private int[] find_indexes(int[] freqs, int[] divisions) {
		int[] indexes = new int[divisions.length];
		int i = 0;
		for (int j=0; j<divisions.length; j++) {
			while (i < freqs.length && freqs[i] < divisions[j]) {
				i++;
			}
			indexes[j] = i;
		}
		return indexes;
	}
	
	private double[] freq_bins(double[] slice) {
		int[] indexes = this.bin_divisions_indexes;
		
		double[] output = new double[indexes.length];
		int prev_index = indexes[0];
		for (int i=1; i<indexes.length; i++) {
			double average = range_average(slice, prev_index, indexes[i] + 1);
			output[i] = average;
		}
		
		return output;
	}
	
	private double range_average(double[] array, int start, int end) {
		int count = end - start;
		double total = 0;
		for (int i=start; i<end; i++) {
			total += array[i];
		}
		return total / count;
	}
	
	private int slice_rolloff_freq(double[] slice, double threshold) {
		double sum = 0;
		for (double i : slice) {
			sum += 1;
		}
		double target = threshold * sum;
		double partial = 0;
		int i = 0;
		while (partial < target && i < slice.length) {
			partial += slice[i];
			i++;
		}
		return i;
	}
	
	private double avg_zero_crossing_rate(int[] sound_data) {
		boolean[] signs = new boolean[sound_data.length];
		for (int i : sound_data) {
			if (i >= 0) {
				signs[i] = true;
			} else {
				signs[i] = false;
			}
		}
		int total = 0;
		for (int i=1; i<signs.length; i++) {
			if (signs[i - 1] != signs[i]) {
				total++;
			}
		}
		double rate = total / sound_data.length;
		return rate;
	}
	
	private double[] normalize(double[] slice) {
		double[][] raw_slices = this.buffers.get("raw_slices").data;
		int end = raw_slices.length;
		
		// Take the moving average to smooth out the data
		int start = end - MOVING_AVERAGE_LENGTH;
		if (start < 0) {
			start = 0;
		}
		double average = range_average(raw_slices, start, end);
		this.buffers.get("averages").push(average);
		
		// Find the sliding minimum value in each frequency band as threshold
		double[][] averages = this.buffers.get("averages").data;
		int start2 = averages.length - MOVING_THRESHOLD_LENGTH;
		if (start2 < 0) {
			start2 = 0;
		}
		double[] threshold = new double[averages[0].length];
		for (int freq_i=0; freq_i<averages[0].length; freq_i++) {
			double[] band = new double[averages.length - start2];
			for (int slice_i=start2; slice_i<averages.length; slice_i++) {
				band[slice_i - start2] = averages[slice_i][freq_i];
			}
			double min = Double.POSITIVE_INFINITY;
			for (int i=0; i<band.length; i++) {
				if (band[i] < min) {
					min = band[i];
				}
			}
			threshold[freq_i] = min;
		}
		
		double[] new_slice = new double[slice.length];
		for (int i=0; i<slice.length; i++) {
			double diff = slice[i] - threshold[i]; // normalize
			if (diff > 0) { // clip at threshold
				new_slice[i] = diff / 10; // scale downwards
			} else {
				new_slice[i] = 0;
			}
		}
		
		return new_slice;
	}
	
	private double[] high_pass_filter(double[] slice, int[] freqs, int cutoff_frequency) {
		// Find the index to cut off at
		int[] divisions = {cutoff_frequency};
		int index = find_indexes(freqs, divisions)[0];
		
		// Perform the filtering
		double[] new_slice = Arrays.copyOfRange(slice, index, slice.length);
		
		return new_slice;
	}
	
	private int[] high_pass_filter_freqs(int[] freqs, int cutoff_frequency) {
		int[] divisions = {cutoff_frequency};
		int index = find_indexes(freqs, divisions)[0];
		int[] new_freqs = Arrays.copyOfRange(freqs, index, freqs.length);
		return new_freqs;
	}
	
	
}
