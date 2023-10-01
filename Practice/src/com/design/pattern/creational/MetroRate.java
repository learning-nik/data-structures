package com.design.pattern.creational;

public abstract class MetroRate {
	
	public abstract float getRate();
	
	public String getDescription(){
		return "THESE IS DELHI METRO";
	}
	
	public float generateBill() {
		return 10* getRate();
		
		
		
	}

}
