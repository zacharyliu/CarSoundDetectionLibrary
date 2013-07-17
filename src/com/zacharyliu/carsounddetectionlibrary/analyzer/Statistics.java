package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
	public static double avg(List<Double> data) {
		double total = 0;
		for (double i : data) {
			total += i;
		}
		return total / data.size();
	}
	
	public static double var(List<Double> data) {
		double mean = avg(data);
		double total = 0;
		for (double i : data) {
			total += Math.pow(i - mean, 2);
		}
		return total / (data.size() - 1);
	}
	
	public static double std(List<Double> data) {
		return Math.sqrt(var(data));
	}
	
	public static List<Double> int_list_to_double(List<Integer> data) {
		List<Double> output = new ArrayList<Double>();
		for (int item : data) {
			output.add((double) item);
		}
		return output;
	}
}
