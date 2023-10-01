package com.questions.arrays;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/smallest-subarray-k-distinct-numbers/
public class MinimumSubArrayOfKDistinct {

	public static void main(String[] args) {

		/*		int a[] = { 1, 1, 1, 2, 2, 2, 3, 3, 3 };
				int k = 3;
		
				findMinLengthWorking(a, k);*/

		int a[] = { 1, 5, 4, 2, 9, 9, 9 };
		int k = 3;
		//System.out.println(maximumSubarraySum(a, k));
		System.out.println(maximumSubarraySumWithoutFirstSlide(a, k));
	}

	// This is also similar to https://leetcode.com/problems/minimum-size-subarray-sum/description/

	private static void findMinLengthWorking(int a[], int k) {

		int i = 0;
		int j = 0;

		int minLength = Integer.MAX_VALUE;

		Map<Integer, Integer> map = new HashMap<>();

		while (j < a.length) {

			// add the element in frequency map
			map.put(a[j], map.getOrDefault(a[j], 0) + 1);

			if (map.size() == k) {

				// Slide the window
				while (map.size() == k) {

					minLength = Math.min(minLength, j - i + 1);

					// remove/reduce the frequency of element at ith position.
					if (map.get(a[i]) == 1) {
						map.remove(a[i]);
					} else {
						map.put(a[i], map.get(a[i]) - 1);
					}

					i++;
				}

			}
			j++;
		}

		System.out.println(minLength);
	}

	//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
	public static long maximumSubarraySum(int[] nums, int k) {

		long maxSum = Integer.MIN_VALUE;
		long sum = 0;
		Map<Integer, Integer> map = new HashMap<>();

		//{ 1, 5, 4, 2, 9, 9, 9 };
		// k=3

		for (int i = 0; i < k - 1; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			sum = sum + nums[i];

		}

		//System.out.println(map);

		int j = k - 1;
		//System.out.println(j);
		while (j < nums.length) {
			sum = sum + nums[j];
			map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

			if (map.size() == k) {
				maxSum = Math.max(maxSum, sum);
			}

			int firstIndex = nums[j - k + 1];
			//System.out.println(firstIndex);
			sum = sum - firstIndex;

			if (map.get(firstIndex) == 1) {
				map.remove(firstIndex);
			} else {
				map.put(firstIndex, map.get(firstIndex) - 1);
			}

			j++;

		}

		return maxSum;
	}

	public static long maximumSubarraySumWithoutFirstSlide(int[] nums, int k) {

		long maxSum = 0;
		long sum = 0;
		Map<Integer, Integer> map = new HashMap<>();

		int j = 0;
		while (j < nums.length) {
			// add the current index to the sum and the map

			sum = sum + nums[j];
			map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

			// Check for maxSum only in case of window has size of k
			if (j >= k - 1) {
				if (map.size() == k) {
					maxSum = Math.max(maxSum, sum);
				}

				// reduce the firstIndex from sum and from map	
				int firstIndex = nums[j - k + 1];
				sum = sum - firstIndex;

				if (map.get(firstIndex) == 1) {
					map.remove(firstIndex);
				} else {
					map.put(firstIndex, map.get(firstIndex) - 1);
				}

			}

			j++;

		}

		return maxSum;

	}

}
