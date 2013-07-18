package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.List;

public final class SliceUtils {
	public static Slice add(Slice a, double b) {
		Slice output = new Slice(a.size());
		for (int i=0; i<a.size(); i++) {
			output.add(a.get(i) + b);
		}
		return output;
	}
	
	public static Slice add(Slice a, Slice b) {
		Slice output = new Slice(a.size());
		for (int i=0; i<a.size(); i++) {
			output.add(a.get(i) + b.get(i));
		}
		return output;
	}
	
	public static Slice sub(Slice a, Slice b) {
		Slice output = new Slice(a.size());
		for (int i=0; i<a.size(); i++) {
			output.add(a.get(i) - b.get(i));
		}
		return output;
	}
	
	public static Slice multiply(Slice a, double b) {
		Slice output = new Slice(a.size());
		for (int i=0; i<a.size(); i++) {
			output.add(a.get(i) * b);
		}
		return output;
	}
	
	public static Slice multiply(Slice a, Slice b) {
		Slice output = new Slice(a.size());
		for (int i=0; i<a.size(); i++) {
			output.add(a.get(i) * b.get(i));
		}
		return output;
	}
	
	public static Slice divide(Slice a, double b) {
		return multiply(a, 1/b);
	}
	
	public static Slice sum(List<Slice> slices) {
		int size = slices.get(0).size();
		Slice output = new Slice(size);
		int count = slices.size();
		for (int i=0; i<size; i++) {
			double total = 0;
			for (int j=0; j<count; j++) {
				total += slices.get(j).get(i);
			}
			output.add(total);
		}
		return output;
	}
	
	public static Slice average(List<Slice> slices) {
		return divide(sum(slices), (double) slices.size());
	}
	
	public static Slice clip(Slice slice, double num) {
		Slice output = new Slice(slice.size());
		for (int i=0; i<slice.size(); i++) {
			if (slice.get(i) > num) {
				output.add(slice.get(i));
			} else {
				output.add(num);
			}
		}
		return output;
	}
}
