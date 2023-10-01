package com.design.pattern.creational;

import java.time.DayOfWeek;

public class TestFactoryDesign {

	public static void main(String[] args) {

		RateFactory rateFactory = new RateFactory(DayOfWeek.SATURDAY);
		MetroRate metroRate=rateFactory.getMetroRate();
		
		System.out.println(metroRate.getRate());
		System.out.println(metroRate.getDescription());
		System.out.println(metroRate.generateBill());
		
	}

}
