package com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers;

import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVector;

public interface Classifier {
	public double[] run(FeatureVector feature_vector);
}
