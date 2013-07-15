package com.zacharyliu.carsounddetectionlibrary;

import java.util.ArrayList;
import java.util.List;

public class DataBuffer<E> {
	private List<E> data;
	private int length;

	public DataBuffer(int length) {
		this.length = length;
		this.data = new ArrayList<E>();
	}
	
	public DataBuffer() {
		this((int) Double.POSITIVE_INFINITY);
	}
	
	public void push(E item) {
		this.data.add(item);
		this.trim();
	}

	private void trim() {
		length = this.data.size();
		if (length > this.length) {
			this.data = this.data.subList(length - this.length, length);
		}
	}
}
