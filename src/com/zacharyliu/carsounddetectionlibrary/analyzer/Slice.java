package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.ArrayList;
import java.util.List;

public class Slice extends ArrayList<Double> {
	public Slice(int size) {
		super(size);
	}
	
	public Slice() {
		super();
	}
	
	public Slice(double[] data) {
		super(data.length);
		for (int i=0; i<data.length; i++) {
			this.add(data[i]);
		}
	}
	
	public Slice(List<Double> data) {
		addAll(data);
	}

	public Slice sub(int start, int end) {
		return new Slice(subList(start, end));
	}
	
	public Slice sub(int start) {
		return sub(start, size());
	}
}
