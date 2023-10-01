package com.questions.arrays;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int arr[] = { -1, -3, 10, -30, 100, 500 };
		
		binarySearch(arr, -1);

	}

	private static void binarySearch(int[] arr, int element) {
		Arrays.sort(arr);
		// binarySearch(arr, element, arr.length);
		binarySearchIterative(arr, element, arr.length);

	}

	private static void binarySearchIterative(int[] arr, int element, int length) {

		int left = 0;
		int right = length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (element == arr[mid]) {
				System.out.println("ELEMENT FOUND");
				return;
			} else {
				if (element > arr[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}

			}
		}
		System.out.println("ELEMENT NOT FOUND");

	}

	static void binarySearch(int arr[], int element, int length) {

		int k = 0;

		if (length == 0) {
			System.out.println("ELEMENT NOT FOUND");
			return;
		}

		if (length == 1 && arr[0] == element) {
			System.out.println("ELEMENT  FOUND");
			return;
		}

		if (element == arr[length / 2]) {
			System.out.println("YES");
			System.out.println("ELEMENT  FOUND");
			return;
		} else {
			if (element > arr[length / 2]) {

				for (int i = (length / 2) + 1; i < length; i++) {
					arr[k++] = arr[i];
				}
			} else {
				for (int i = 0; i < length / 2; i++) {
					arr[k++] = arr[i];
				}
			}
		}
		binarySearch(arr, element, k);

	}

}
