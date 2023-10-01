package com.questions.arrays;

import java.util.Arrays;

/*https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
*/public class LargestNumberFormed {

	public static void main(String[] args) {

		// String arr[] = { "3", "30", "34", "5", "9" };

		//String arr[] = { "1", "34", "3", "98", "9", "76", "45", "4" };

		//System.out.println(findLargestNumberFormed(arr));
		//System.out.println(findLargestNumberFormed2(arr));

		//int arr[] = { 3, 30, 34, 5, 9 };

		int arr[] = { 0, 0, };

		System.out.println(largestNumber(arr));

	}

	//TC : O(n^2)
	private static String findLargestNumberFormed(String[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				int value1 = Integer.parseInt(arr[i] + arr[j]);
				int value2 = Integer.parseInt(arr[j] + arr[i]);

				String temp;
				if (value2 > value1) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ", ");
		}
		return sb.toString();
	}

	//TC : O(n logn) 
	// Sort an array in desc order on custom comparator
	private static String findLargestNumberFormed2(String[] arr) {

		Arrays.sort(arr, (s1, s2) -> {

			Integer value1 = Integer.parseInt(s1 + s2);
			Integer value2 = Integer.parseInt(s2 + s1);

			return value2.compareTo(value1);
		});

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();

	}

	// https://leetcode.com/problems/largest-number/description/
	public static String largestNumber(int[] nums) {
		String[] data = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			data[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(data, (s1, s2) -> {
			return (s2 + s1).compareTo(s1 + s2);
		});

		if (data[0].charAt(0) == '0')
			return "0";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(data[i]);

		}

		return sb.toString();
	}

}
