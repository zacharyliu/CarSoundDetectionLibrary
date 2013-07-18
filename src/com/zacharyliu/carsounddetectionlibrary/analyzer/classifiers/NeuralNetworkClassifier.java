package com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers;

import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVector;
import com.zacharyliu.carsounddetectionlibrary.analyzer.Result;

public class NeuralNetworkClassifier implements Classifier {

	@Override
	public Result run(FeatureVector feature_vector) {
		// TODO Run neural network classification
//		int[] result = {0,1};
		Result result = new Result(new int[] {(int) (Math.random() * 10)});
		return result;
	}

}
