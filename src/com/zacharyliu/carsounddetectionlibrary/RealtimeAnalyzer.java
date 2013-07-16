package com.zacharyliu.carsounddetectionlibrary;

import java.util.List;

import com.zacharyliu.carsounddetectionlibrary.classifier.Classifier;

public class RealtimeAnalyzer {
	private Classifier classifier;
	private FeatureVectorExtractor extractor;
	private DataBuffer<Double> buffer;

	public RealtimeAnalyzer(int rate, Classifier classifier) {
		this.classifier = classifier;
		this.extractor = new FeatureVectorExtractor(rate);
		this.buffer = new DataBuffer<Double>(100);
	}
	
	public void push(List<Integer> samples) {
		List<FeatureVector> feature_vectors = extractor.push(samples);
		for (FeatureVector vector : feature_vectors) {
			List<Double> result = classifier.run(vector);
		}
	}
}
