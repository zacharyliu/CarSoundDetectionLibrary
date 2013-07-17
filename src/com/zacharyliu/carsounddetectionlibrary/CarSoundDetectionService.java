package com.zacharyliu.carsounddetectionlibrary;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class CarSoundDetectionService extends Service {
	
	private final IBinder mBinder = new CarSoundDetectionBinder();

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	public class CarSoundDetectionBinder extends Binder {
		CarSoundDetectionService getService() {
			return CarSoundDetectionService.this;
		}
	}
	
	public boolean start() {
		return true;
	}
	
}
