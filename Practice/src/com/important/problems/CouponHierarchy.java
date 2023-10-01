package com.important.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/discuss/interview-question/3788608/WAYFAIR-DSA-Round-1-or-SDE-II

public class CouponHierarchy {

	private static Map<String, Coupon> couponMap = new HashMap<>();

	private static Map<String, String> categoryMap = new HashMap<>();

	private static Map<String, List<Coupon>> multiCouponMap = new HashMap<>();

	public static void main(String[] args) {

		// Add coupons 
		addCoupons("Comforter Sets", "Comforters Sale");
		addCoupons("Bedding", "Savings on Bedding");
		addCoupons("Bed & Bath", "Low price for Bed & Bath");
		addCoupons("Soap Dispensers", "Low price for Soaps");

		// Add categories
		addCategories("Comforter Sets", "Bedding");
		addCategories("Bedding", "Bed & Bath");
		addCategories("Bed & Bath", null);
		addCategories("Soap Dispensers", "Bathroom Accessories");
		addCategories("Bathroom Accessories", "Bed & Bath");
		addCategories("Toy Organizers", "Baby And Kids");
		addCategories("Baby And Kids", null);

		//System.out.println(categoryMap);

		// test data

		/*tests: 
		 * input(CategoryName) => output(CouponName)
				"Comforter Sets" => "Comforters Sale"
				"Bedding" => "Savings on Bedding"
				"Bathroom Accessories" => "Low price for Bed & Bath"
				"Soap Dispensers" => "Low price for Bed & Bath"
				"Toy Organizers" => null*/

		//System.out.println(getCoupon("Comforter Sets"));
		//System.out.println(getCoupon("Bedding"));
		//System.out.println(getCoupon("Bathroom Accessories"));
		System.out.println(getCoupon("Soap Dispensers"));
		//System.out.println(getCoupon("Toy Organizers"));

		List<String> answer = new ArrayList<>();
		getAllCoupons("Soap Dispensers", answer);
		System.out.println(answer);

	}

	public static String getCoupon(String category) {

		// base conditions
		if (category == null) {
			return null;
		}

		if (couponMap.containsKey(category)) {
			return couponMap.get(category).getName();
		}

		// find the coupon from the parent	
		String parentCategory = categoryMap.get(category);
		return getCoupon(parentCategory);

	}

	public static void getAllCoupons(String category, List<String> couponList) {

		// base conditions
		if (category == null) {
			return;
		}

		if (couponMap.containsKey(category)) {
			couponList.add(couponMap.get(category).getName());

		}

		// find the coupon from the parent	
		String parentCategory = categoryMap.get(category);
		getAllCoupons(parentCategory, couponList);

	}

	private static void addCategories(String categoryName, String parentCategory) {

		categoryMap.put(categoryName, parentCategory);
	}

	private static void addCoupons(String categoryName, String couponName) {

		couponMap.put(categoryName, new Coupon(couponName, System.currentTimeMillis()));

	}

}

class Coupon {

	String name;

	long timeAdded;

	Coupon(String name, long timeAdded) {
		this.name = name;
		this.timeAdded = timeAdded;
	}

	public String getName() {
		return name;
	}

	public long getTimeAdded() {
		return timeAdded;
	}

}
