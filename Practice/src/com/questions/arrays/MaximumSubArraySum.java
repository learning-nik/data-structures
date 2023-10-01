package com.questions.arrays;

/*https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/*/
//KADANE ALG
public class MaximumSubArraySum {

	public static void main(String[] args) {

		//int a[] = { 1,2,-2,4,0};
		//int a[] ={1, 2, 3, -2, 5};
		// int a[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		//int a[] = {-1, -2, 0}; 
		int a[] = { -2, 3, -4 };
		//System.out.println(maxSum(a));
		System.out.println(maxProduct(a));
	}

	private static int maxSum(int[] a) {

		int maxSum = a[0];
		int lastMax = a[0];

		for (int i = 1; i < a.length; i++) {
			lastMax = Math.max(a[i], a[i] + lastMax);
			if (lastMax > maxSum) {
				maxSum = lastMax;
			}
		}

		return maxSum;

	}

	//	https://leetcode.com/problems/maximum-product-subarray/
	public static int maxProduct(int[] nums) {

		int lastMax = nums[0];
		int lastMin = nums[0];
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] < 0) {
				//swap
				int temp = lastMax;
				lastMax = lastMin;
				lastMin = temp;
			}

			lastMax = Math.max(nums[i], nums[i] * lastMax);
			lastMin = Math.min(nums[i], nums[i] * lastMin);

			max = Math.max(max, lastMax);

		}

		return max;
	}

}
