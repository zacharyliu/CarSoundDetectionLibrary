package com.zacharyliu.carsounddetectionlibrary.analyzer;

public class Result {
	private double[] array;

	public Result(double[] data) {
		array = data;
	}
	
	public double getResult() {
		int sum = 0;
		for (double item : array) {
			sum += item;
		}
		return (double) sum / array.length;
	}
}
