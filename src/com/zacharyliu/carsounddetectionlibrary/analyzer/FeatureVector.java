package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.ArrayList;

public class FeatureVector extends ArrayList<Double> {
	private static final long serialVersionUID = 4774995738774315766L; // auto-generated

	public FeatureVector() {
		super();
	}
	
	public void addAll(double[] data) {
		int size = data.length;
		for (int i=0; i<size; i++) {
			add(data[i]);
		}
	}
	
	public double[] toRawArray() {
		Object[] inArray = super.toArray();
		double[] outArray = new double[inArray.length];
		for (int i=0; i<inArray.length; i++) {
			outArray[i] = (Double) inArray[i];
		}
		return outArray;
	}
}
