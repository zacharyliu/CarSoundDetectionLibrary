package com.zacharyliu.carsounddetectionlibrary;

import com.zacharyliu.carsounddetectionlibrary.analyzer.Result;

public interface CarSoundDetectionReceiver {
	public void onResult(Result result);
}
