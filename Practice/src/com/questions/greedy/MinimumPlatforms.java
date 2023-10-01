package com.questions.greedy;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
//https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
// https://www.youtube.com/watch?v=38JLfQGVlkw
// Meeting rooms 2 as per leetcode.
// https://www.youtube.com/watch?v=PWgFnSygweI
public class MinimumPlatforms {

	public static void main(String[] args) {

		/*		float[] a1 = { 9.00f, 10, 10, 12 };
				float[] a2 = { 9.10f, 10.30f, 12, 12.10f };*/

		float arr[] = { 9.00f, 9.40f, 9.50f, 11.00f, 15.00f, 18.00f };
		float dep[] = { 9.10f, 12.00f, 11.20f, 11.30f, 19.00f, 20.00f };

		minPlatformsBruteForce(arr, dep);

		System.out.println(findPlatform(arr, dep, arr.length));

	}

	// O(n^2)
	private static void minPlatformsBruteForce(float[] arr, float[] dep) {

		int answer = 1;
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			int minPlatforms = 1;
			for (int j = 0; j < len; j++) {
				if (i != j) {

					// Arrival of train 1 is after 2nd train 
					// and its arrival is before the other departs
					if (arr[i] >= arr[j] && arr[i] <= dep[j]) {
						minPlatforms++;
					}

				}
			}
			answer = Math.max(answer, minPlatforms);
		}
		System.out.println(answer);
	}

	// After sorting both		  
	//float a1[] = { 9.00f, 9.40f, 9.50f, 11.00f, 15.00f, 18.00f }; 
	//float a2[] = {9.10f, , 11.20f, 11.30f, 12.00f, 19.00f, 20.00f };
	static int findPlatform(float arr[], float dep[], int n) {

		Arrays.sort(arr);
		Arrays.sort(dep);
		int answer = 1;
		int current = 1;

		int i = 1; // arrival is tracked by i
		int j = 0; // departure is tracked by j

		while (j < arr.length && i < dep.length) {
			if (arr[i] <= dep[j]) {
				// Current train has arrived and the last one has not yet left.
				// we need more platforms.
				// arrival counter incremented.
				current++;
				i++;
			} else {
				// Current train has arrived and the last has already left.
				// reduce the no of platforms
				// departure counter incremented.
				current--;
				j++;
			}

			answer = Math.max(answer, current);

		}

		return answer;

	}
	//{0900, 0940, 0950, 1100, 1500, 1800}

	//{0910,  1120, 1130, 1200,1900, 2000}

	//{0910, 1200, 1120, 1130, 1900, 2000}
	// min platforms using other code
	static int findPlatform2(float arr[], float dep[], int n) {

		int minPlatforms = 1;

		int answer = Integer.MIN_VALUE;

		Arrays.sort(arr);

		Arrays.sort(dep);

		int end = 0;

		for (int i = 1; i < arr.length; i++) {

			answer = Math.max(answer, minPlatforms);
			// new train has arrived , so increase no of platforms
			minPlatforms++;

			if (arr[i] > dep[end]) {
				// check if any trains have left , if so reduce the platforms
				while (arr[i] > dep[end] && end < dep.length) {
					end++;
					minPlatforms--;
				}
			}

		}

		return answer;

	}
}
