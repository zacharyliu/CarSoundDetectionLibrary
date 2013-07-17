package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.List;

import android.os.AsyncTask;

import com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers.Classifier;

public class RealtimeAnalyzer extends AsyncTask<Void, Void, Void> {
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

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		return null;
	}
}
