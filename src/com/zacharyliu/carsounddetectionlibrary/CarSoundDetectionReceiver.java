package com.zacharyliu.carsounddetectionlibrary;

import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVector;

public interface CarSoundDetectionReceiver {
	public void onResult(FeatureVector vector);
}
