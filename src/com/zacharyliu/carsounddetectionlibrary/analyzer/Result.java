package com.zacharyliu.carsounddetectionlibrary.analyzer;

public class Result {
	private int[] array;

	public Result(int[] data) {
		array = data;
	}
	
	public double getResult() {
		int sum = 0;
		for (int item : array) {
			sum += item;
		}
		return (double) sum / array.length;
	}
}
