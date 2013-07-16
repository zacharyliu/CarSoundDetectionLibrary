package com.zacharyliu.carsounddetectionlibrary;

import java.util.ArrayList;

public class Slice extends ArrayList<Double> {
	public Slice(int size) {
		super(size);
	}
	
	public Slice() {
		super();
	}

	public Slice sub(int start, int end) {
		return (Slice) subList(start, end);
	}
	
	public Slice sub(int start) {
		return sub(start, size());
	}
}
