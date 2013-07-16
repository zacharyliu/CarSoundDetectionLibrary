package com.zacharyliu.carsounddetectionlibrary.classifier;

import java.util.List;
import java.util.Map;

import com.zacharyliu.carsounddetectionlibrary.FeatureVector;

public interface Classifier {
	public List<Double> run(FeatureVector feature_vector);
}
