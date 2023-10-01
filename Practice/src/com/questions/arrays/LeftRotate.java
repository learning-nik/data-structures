package com.questions.arrays;

import java.util.ArrayList;
import java.util.List;

//DSA videos
public class LeftRotate {

	public static void main(String[] args) {

		/*int a[] = { 1, 3, 5, 7, 9 };
		int d = 4;
		
		leftRotateMethod1(a, d);*/

		int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;

		//rotate(nums, k);
		rotate2(nums, k);
		printArray(nums);

	}

	private static void leftRotateMethod1(int[] a, final int d) {

		int a2[] = new int[d];
		for (int i = 0; i < d; i++) {
			a2[i] = a[i];
		}
		for (int i = 0; i < a.length - d; i++) {
			a[i] = a[i + d];
		}

		int k = a.length - d;
		for (int i = 0; i < d; i++) {
			a[k++] = a2[i];
		}

		printArray(a);
	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}

	public static void rotate(int[] nums, int k) {

		if (k > nums.length) {
			k = k % nums.length;
		}

		if (k == 0) {
			return;
		}

		List<Integer> list = new ArrayList<>();

		// Add the last k elements of the array to list
		for (int i = nums.length - k; i < nums.length; i++) {
			list.add(nums[i]);
		}

		// Add the remaining elements of the array to list        
		for (int i = 0; i <= nums.length - k; i++) {
			list.add(nums[i]);
		}

		// Copy data from list to array
		for (int i = 0; i < nums.length; i++) {
			nums[i] = list.get(i);
		}

	}

	// yet to implement
	public static void rotate2(int[] nums, int k) {

		if (k > nums.length) {
			k = k % nums.length;
		}

		if (k == 0) {
			return;
		}

		for (int i = 0; i < k; i++) {

			int temp = nums[i];
			nums[i] = nums[nums.length - k + i];
			nums[nums.length - k + i] = temp;

		}

	}
}
