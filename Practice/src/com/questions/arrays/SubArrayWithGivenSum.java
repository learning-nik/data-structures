package com.questions.arrays;

/*https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
 * Given an unsorted array A of size N that contains only non-negative integers, 
 * find a continuous sub-array which adds to a given number S.
*/
public class SubArrayWithGivenSum {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 7, 5 };
		int sum = 13;
		/*int a[] = { 12, 1, 3, 7, 5 };*/
		
		/*
		   int a[] ={1,2,3,4,5,6,7,8,9,10}; 
		   int sum = 15;
		 */
		System.out.println(findSubArray(a, sum));
		System.out.println(findSubArrayBF(a, sum));
	}

	// TC : O(N)
	private static String findSubArray(int[] a, int sum) {
		int outSum = a[0];
		int i = 0;
		int j = 1;

		while (i < a.length && j < a.length) {

			if (outSum == sum) {
				return i + ", " + (j - 1);
			} else if (outSum > sum) {
				outSum = outSum - a[i];
				i++;
			} else {
				outSum = outSum + a[j];
				j++;
			}
		}
		return "NO";
	}
	
	// TC: O(N^2)
	// Using 2 for loops and calculating the sum of each subarray.
	private static String findSubArrayBF(int[] a, int sum) {
		int subSum;
		for (int i = 0; i < a.length; i++) {
			subSum = a[i];
			for (int j = i + 1; j < a.length; j++) {
				subSum = subSum + a[j];
				if (subSum == sum) {
					return i + ", " + j;
				}
			}

		}

		return "NO";
	}

}
