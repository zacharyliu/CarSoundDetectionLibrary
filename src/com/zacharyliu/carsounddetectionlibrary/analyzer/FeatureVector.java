package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.ArrayList;

public class FeatureVector extends ArrayList<Double> {
	public FeatureVector() {
		super();
	}
	
	public void addAll(double[] data) {
		int size = data.length;
		for (int i=0; i<size; i++) {
			add(data[i]);
		}
	}
}
