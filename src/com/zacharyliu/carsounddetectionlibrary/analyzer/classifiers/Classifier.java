package com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers;

import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVector;
import com.zacharyliu.carsounddetectionlibrary.analyzer.Result;

public interface Classifier {
	public Result run(FeatureVector feature_vector);
}
