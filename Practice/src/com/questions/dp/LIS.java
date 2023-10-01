package com.questions.dp;
// 300. Longest Increasing Subsequence

// Using Binary search TC : nlogn
// Using DP : n^2

public class LIS {

	//https://leetcode.com/problems/longest-increasing-subsequence/
	public static void main(String[] args) {

		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(new LIS().lengthOfLIS(nums));

	}

	// Using Binary Search
	public int lengthOfLIS(int[] nums) {

		int temp[] = new int[nums.length];
		int length = 1;
		temp[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {

			// if element to be added is more than the last added element in temp  array.
			// then directly add it to the temp array 
			if (temp[length - 1] < nums[i]) {
				temp[length] = nums[i];
				length++;
			} else {
				// if element to be added in less or equal to the last element
				// search for the element or next greater to it in the temp array 
				// replace with the current element
				int index = search(temp, nums[i], length - 1);
				temp[index] = nums[i];
			}

		}

		return length;

	}

	private int search(int[] nums, int element, int right) {
		int left = 0;
		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] >= element) {
				right = mid;
			} else {
				left = mid + 1;
			}

		}
		return right;
	}

}
