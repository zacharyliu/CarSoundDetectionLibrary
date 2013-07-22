package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.ArrayList;

import com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers.Classifier;

public class FeatureVector extends ArrayList<Double> {
	private static final long serialVersionUID = 4774995738774315766L; // auto-generated
	public double[] result;

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
	
	public void classify(Classifier classifier) {
		result = classifier.run(this);
	}
	
	public double getResult() {
		double sum = 0;
		for (double item : result) {
			sum += item;
		}
		return (double) sum / result.length;
	}
	
	public String[] toStringArray() {
		int size = size();
		String[] output = new String[size + result.length];
		for (int i=0; i<size; i++) {
			output[i] = Double.toString(get(i));
		}
		for (int i=0; i<result.length; i++) {
			output[size + i] = Double.toString(result[i]);
		}
		return output;
	}
}
