package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeatureVectorExtractor {
	private static final int[] DIVISIONS = {500, 1000, 2500, 5000, 7000};
	private static final int MOVING_AVERAGE_LENGTH = 3; // length in number of FFT intervals
	private static final int MOVING_THRESHOLD_LENGTH = 30;
//	private int rate;
//	private final int FRAME_TIME_LENGTH = 180;
	private int fft_sample_length;
	private int overlap_sample_length;
	private AudioBuffer audio_buffer;
//	private Map<String, DataBuffer<?>> buffers;
	private FFT fft;
	private List<Double> original_freqs;
	private List<Double> freqs;
	private List<Integer> bin_divisions_indexes;
	private double maxFreq;
	private DataBuffer<Slice> raw_slices_buffer;
	private DataBuffer<Slice> averages_buffer;
	private int numFreqs;
	
	public FeatureVectorExtractor(int rate) {
//		this.rate = rate;
		FFTSizeCalculator calculator = new FFTSizeCalculator(rate);
		fft_sample_length = calculator.fft_sample_length;
		overlap_sample_length = calculator.overlap_sample_length;
		audio_buffer = new AudioBuffer(fft_sample_length, overlap_sample_length);
		fft = new FFT(rate);
		original_freqs = fft.freqs;
		freqs = high_pass_filter_freqs(original_freqs, 500);
		numFreqs = freqs.size();
		bin_divisions_indexes = find_indexes(freqs, DIVISIONS);
		maxFreq = Collections.max(freqs);
		
		raw_slices_buffer = new DataBuffer<Slice>();
		averages_buffer = new DataBuffer<Slice>();
	}
	
	private List<Integer> find_indexes(List<Double> freqs, int[] divisions) {
		List<Integer> indexes = new ArrayList<Integer>(divisions.length);
		int i = 0;
		for (int j=0; j<divisions.length; j++) {
			while (i < freqs.size() && freqs.get(i) < divisions[j]) {
				i++;
			}
			indexes.add(i);
		}
		return indexes;
	}
	
	private Slice freq_bins(Slice slice) {
		List<Integer> indexes = this.bin_divisions_indexes;
		
		Slice output = new Slice(indexes.size());
		int prev_index = indexes.get(0);
		for (int i=1; i<indexes.size(); i++) {
			double average = range_average(slice, prev_index, indexes.get(i) + 1);
			output.add(average);
		}
		
		return output;
	}
	
	private double range_average(Slice array, int start, int end) {
		int count = end - start;
		double total = 0;
		for (int i=start; i<end; i++) {
			total += array.get(i);
		}
		return total / count;
	}
	
	private int slice_rolloff_freq(Slice slice, double threshold) {
		double sum = Statistics.sum(slice);
		double target = threshold * sum;
		double partial = 0;
		int i = 0;
		while (partial < target && i < slice.size() - 1) {
			partial += slice.get(i);
			i++;
		}
		return i;
	}
	
	private double avg_zero_crossing_rate(int[] data) {
		boolean[] signs = new boolean[data.length];
		for (int i=0; i<data.length; i++) {
			if (data[i] >= 0) {
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
		double rate = (double) total / data.length;
		return rate;
	}
	
	private Slice normalize(Slice slice) {
		List<Slice> raw_slices = this.raw_slices_buffer.data;
		int end = raw_slices.size();
		
		// Take the moving average to smooth out the data
		int start = end - MOVING_AVERAGE_LENGTH;
		if (start < 0) {
			start = 0;
		}
		Slice average = SliceUtils.average(raw_slices.subList(start, end));
		this.averages_buffer.push(average);
		
		// Find the sliding minimum value in each frequency band as threshold
		List<Slice> averages = this.averages_buffer.data;
		int start2 = averages.size() - MOVING_THRESHOLD_LENGTH;
		if (start2 < 0) {
			start2 = 0;
		}
		Slice threshold = new Slice(numFreqs);
		int bandLength = averages.size() - start2;
		for (int freq_i=0; freq_i<numFreqs; freq_i++) {
			double[] band = new double[bandLength];
			for (int slice_i=0; slice_i<bandLength; slice_i++) {
				band[slice_i] = averages.get(slice_i + start2).get(freq_i);
			}
			double min = band[0];
			for (int i=1; i<band.length; i++) {
				if (band[i] < min) {
					min = band[i];
				}
			}
			threshold.add(min);
		}
		
		Slice new_slice = SliceUtils.sub(slice, threshold); // normalize
		new_slice = SliceUtils.clip(new_slice, 0); // clip at threshold
		new_slice = SliceUtils.divide(new_slice, 10); // scale downwards
		
		return new_slice;
	}
	
	private Slice high_pass_filter(Slice slice, List<Double> freqs, int cutoff_frequency) {
		// Find the index to cut off at
		int[] divisions = {cutoff_frequency};
		int index = find_indexes(freqs, divisions).get(0);
		
		// Perform the filtering
		Slice new_slice = slice.sub(index);
		
		return new_slice;
	}
	
	private List<Double> high_pass_filter_freqs(List<Double> freqs, int cutoff_frequency) {
		int[] divisions = {cutoff_frequency};
		int index = find_indexes(freqs, divisions).get(0);
		List<Double> new_freqs = freqs.subList(index, freqs.size());
		return new_freqs;
	}
	
	private double[] pairwise_differences(Slice items) {
		int size = items.size();
		int count = size * (size-1) / 2;
		double[] ratios = new double[count];
		
		int index = 0;
		for (int i=0; i<size; i++) {
			for (int j=i+1; j<size; j++) {
				ratios[index] = items.get(i) - items.get(j);
				index++;
			}
		}
		return ratios;
	}
	
	public FeatureVector analyze(int[] data) {
		Slice raw_slice = this.fft.run(data);
		
		// Decibel scale
		for (int i=0; i<raw_slice.size(); i++) {
			double new_slice = 10 * Math.log10(raw_slice.get(i)) + 60;
			if (new_slice > 0) {
				raw_slice.set(i, new_slice);
			} else {
				raw_slice.set(i, 0.0);
			}
		}
		
		// High-pass filter
		raw_slice = high_pass_filter(raw_slice, original_freqs, 500);
		
		// Add raw slices to buffer for use in calculating moving average
		raw_slices_buffer.push(raw_slice);
		
		// Normalize the slices for analysis purposes
		Slice slice = normalize(raw_slice);
//		buffers.get("slices").push(slice);
		
		// Calculate zero-crossing rate
		double zero_crossing_rate = avg_zero_crossing_rate(data);
//		buffers.get("zero_crossing_rates").push(zero_crossing_rate);
		
		// Calculate rolloff frequencies
		double rolloff_freq = freqs.get(slice_rolloff_freq(slice, 0.9)) / maxFreq;
		
		// Divide each slice into frequency bins
		Slice slice_bins = freq_bins(slice);
//		buffers.get("slices_bins").push(slice_bins);
		
		// Extract the third octave
//		int[] third_octave_range = {700, 1300};
//		List<Integer> third_octave_indexes = find_indexes(freqs, third_octave_range);
//		Slice third_octave = slice.sub(third_octave_indexes.get(0), third_octave_indexes.get(1));
//		buffers.get("third_octave").push(third_octave);
		
		// Pairwise differences (ratio of magnitude) between frequency bins
		double[] ratios = pairwise_differences(slice_bins);
//		buffers.get("ratios").push(ratios);
		
		// Overall magnitude of sound
		double magnitude = 0;
		for (int i=0; i<slice.size(); i++) {
			magnitude += slice.get(i);
		}
		magnitude /= numFreqs;
//		buffers.get("magnitude").push(magnitude);
		
		// Standard deviation of frequency spectrum
		double stddev = Statistics.std(slice);
//		buffers.get("stddev").push(stddev);
		
		// Create feature vectors
		FeatureVector vector = new FeatureVector();
		vector.addAll(ratios);
		vector.add(zero_crossing_rate);
		vector.add(stddev);
		vector.add(rolloff_freq);
		vector.add(magnitude);
		
		return vector;
	}
	
	public List<FeatureVector> push(int[] samples) {
		audio_buffer.push(samples);
		List<FeatureVector> vectors = new ArrayList<FeatureVector>();
		while (audio_buffer.available()) {
			FeatureVector vector = analyze(audio_buffer.read());
			vectors.add(vector);
		}
		return vectors;
	}
}
