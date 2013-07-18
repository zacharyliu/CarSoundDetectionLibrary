package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
	public static double avg(Slice data) {
		int size = data.size();
		return sum(data) / size;
	}
	
	public static double var(Slice data) {
		double mean = avg(data);
		double total = 0;
		int size = data.size();
		for (int i=0; i<size; i++) {
			total += Math.pow(data.get(i) - mean, 2);
		}
		return total / (size - 1);
	}
	
	public static double std(Slice data) {
		return Math.sqrt(var(data));
	}
	
	public static List<Double> int_list_to_double(List<Integer> data) {
		List<Double> output = new ArrayList<Double>();
		for (int item : data) {
			output.add((double) item);
		}
		return output;
	}

	public static double sum(Slice data) {
		double total = 0;
		int size = data.size();
		for (int i=0; i<size; i++) {
			total += data.get(i);
		}
		return total;
	}
}
