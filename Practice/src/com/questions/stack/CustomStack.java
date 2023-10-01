package com.questions.stack;

import java.util.Arrays;

/*STACK USING ARRAYS*/
public class CustomStack {

	private int[] array;

	private int size;

	private int maxSize = 3;

	public CustomStack() {
		array = new int[maxSize];
	}

	public void push(int element) {
		if (size == maxSize) {
			array = Arrays.copyOf(array, maxSize * 2);
			maxSize = maxSize * 2;
		}
		array[size] = element;
		size++;
	}

	public int pop() {
		int element = array[size - 1];
		size--;
		return element;
	}

	public int getLength() {
		return size;
	}
}
