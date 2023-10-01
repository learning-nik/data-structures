package com.questions.arrays;

// https://www.geeksforgeeks.org/window-sliding-technique
// More problems for sliding window --> https://www.geeksforgeeks.org/tag/sliding-window/
public class MaxSubArraySumOfSizek {

	public static void main(String[] args) {

		int a[] = {100, 200, 300, 400};
        int k = 2;
        
        /*int a[] ={1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;*/
        
        System.out.println(maxSum(a,k));
        System.out.println(maxSumBruteForce(a,k));
	}

	// TC : O(n)
	// Calculate the sum of the first window and then slide the window for the rest of the array.
	private static int maxSum(int[] a, int k) {

		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += a[i];
		}
		maxSum = Math.max(sum, maxSum);
		for (int i = k; i < a.length; i++) {
			sum = sum - a[i - k] + a[i];
			maxSum = Math.max(sum, maxSum);
		}

		return maxSum;
	}
	
	// TC : O(n*k)
	// Using 2 for loops.
	private static int maxSumBruteForce(int[] a, int k) {

		int maxSum = 0;
		for (int i = 0; i <= a.length - k; i++) {
			int sum = 0;
			for (int j = i; j < i + k; j++) {
				sum = sum + a[j];
			}
			maxSum = Math.max(maxSum, sum);
		}

		return maxSum;
	}
	
}
