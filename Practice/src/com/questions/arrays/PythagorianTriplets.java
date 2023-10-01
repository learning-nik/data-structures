package com.questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
 * https://leetcode.com/problems/3sum/description/	
*/public class PythagorianTriplets {

	public static void main(String[] args) {

		int a[] = { 3, 1, 4, 6, 5 };
		// int a[] = {10, 4, 6, 12, 5};

		checkIfTripletExists(a);
	}

	private static void checkIfTripletExists(int[] a) {
		Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {
			a[i] *= a[i];
		}

		for (int i = a.length - 1; i >= 2; i--) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				if (a[i] == a[left] + a[right]) {
					System.out.println("YES");
					break;
				} else if (a[i] > a[left] + a[right]) {
					left++;
				} else {
					right--;
				}
			}
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> finalList = new ArrayList<>();
		Set<List<Integer>> finalSet = new HashSet<>();
		List<Integer> subList = new ArrayList<>();

	
		for (int i = 0; i < nums.length - 2; i++) {
			
			int left = i + 1;
			int right = nums.length - 1;
			
			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];

				if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					// when sum ==0
					subList.add(nums[left++]);
					subList.add(nums[right--]);
					subList.add(nums[i]);
					finalSet.add(subList);
					subList = new ArrayList<>();

				}
			}

		}

		finalList = new ArrayList<>(finalSet);

		return finalList;

	}

}
