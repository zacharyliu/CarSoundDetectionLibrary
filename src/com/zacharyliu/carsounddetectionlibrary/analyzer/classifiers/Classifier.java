package com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers;

import java.util.List;
import java.util.Map;

import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVector;

public interface Classifier {
	public List<Integer> run(FeatureVector feature_vector);
}
