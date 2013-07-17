package com.zacharyliu.carsounddetectionlibrary.analyzer;

import java.util.ArrayList;
import java.util.List;

public class DataBuffer<E> {
	public List<E> data;
	private int length;

	public DataBuffer(int length) {
		this.length = length;
		this.data = new ArrayList<E>();
	}
	
	public DataBuffer() {
		this(-1);
	}
	
	public void push(E item) {
		this.data.add(item);
		this.trim();
	}

	private void trim() {
		if (length > -1) {
			length = this.data.size();
			if (length > this.length) {
				this.data = this.data.subList(length - this.length, length);
			}
		}
	}
}
