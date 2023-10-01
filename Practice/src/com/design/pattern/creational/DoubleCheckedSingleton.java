package com.design.pattern.creational;

public class DoubleCheckedSingleton {

	private DoubleCheckedSingleton() {}

	private volatile static DoubleCheckedSingleton instance ;

	public void getData() {
		System.out.println(this.hashCode());
	}

	public static DoubleCheckedSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckedSingleton();
				}
			}
		}
		return instance;
	}
}
