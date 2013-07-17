package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.List;

public class FeatureVectorBuffer extends DataBuffer<List<Double>> {
	private DataBuffer<Double> results;

	public FeatureVectorBuffer(int length) {
		super(length);
		this.results = new DataBuffer<Double>(length);
	}
	
	public FeatureVectorBuffer() {
		this((int) Double.POSITIVE_INFINITY);
	}
	
	public void add_vector(List<Double> feature_vector) {
		super.push(feature_vector);
		double result = this.classify(feature_vector);
		this.results.push(result);
	}

	private double classify(List<Double> feature_vector) {
		// TODO Auto-generated method stub
		return 0;
	}
}
