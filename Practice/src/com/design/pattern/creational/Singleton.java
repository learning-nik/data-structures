package com.design.pattern.creational;

public class Singleton {
	
	private Singleton() {}

	private static final Singleton INSTANCE = new Singleton();

	public void getData() {
		System.out.println(this.hashCode());
	}

	public static Singleton getInstance() {
		return INSTANCE;
	}

}
