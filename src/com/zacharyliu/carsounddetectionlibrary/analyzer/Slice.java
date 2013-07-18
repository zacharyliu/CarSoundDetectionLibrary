package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.List;

public class Slice {
	private double[] data;
	private int index = 0;
	
	public Slice(int size) {
		data = new double[size];
	}
	
	public Slice(double[] data) {
		this.data = data;
	}
	
	public Slice(List<Double> data) {
		Double[] temp = (Double[]) data.toArray();
		for (int i=0; i<temp.length; i++) {
			this.data[i] = (double) temp[i];
		}
	}

	public Slice sub(int start, int end) {
		double[] newdata = new double[end-start];
		for (int i=0; i<end-start; i++) {
			newdata[i] = data[start+i];
		}
		return new Slice(newdata);
	}
	
	public Slice sub(int start) {
		return sub(start, size());
	}
	
	public void add(double item) {
		data[index] = item;
		index++;
	}
	
	public int size() {
		return data.length;
	}
	
	public double get(int i) {
		return data[i];
	}
	
	public void set(int i, double value) {
		data[i] = value;
	}
}
