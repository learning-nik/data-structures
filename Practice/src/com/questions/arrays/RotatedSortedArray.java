package com.questions.arrays;

public class RotatedSortedArray {

	public static void main(String[] args) {

		int a[] = { 4, 5, 6, 7, 0, 1, 2 };

		//search(a, 2);
		System.out.println(findMin(a));
	}

	public static int search(int[] a, int target) {

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (a[mid] == target) {
				System.out.println("element found at index :::" + mid);
				return mid;
			}

			if (a[low] <= a[mid]) {
				// left side is sorted
				if (target >= a[low] && target <= a[mid]) {
					// element in present in this range
					high = mid - 1;
				} else {
					low = mid + 1;
				}

			} else {
				// right side is sorted
				if (target <= a[high] && target >= a[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

		}

		return -1;

	}

	public static int findMin(int[] a) {

		int left = 0;
		int right = a.length - 1;

		if (a.length == 1) {
			// only one element is present
			return a[0];
		}

		if (a[right] > a[left]) {
			// array is already sorted
			return a[left];
		}

		while (left <= right) {

			int mid = (left + right) / 2;

			if (a[mid] > a[mid + 1]) {
				return a[mid + 1];
			}

			if (a[mid - 1] > a[mid]) {
				return a[mid];
			}

			if (a[left] < a[mid]) {
				// left side is sorted , check for pivot on the right side
				left = mid + 1;
			} else {
				// right side is sorted , check for pivot on the left side
				right = mid - 1;
			}

		}

		return -1;
	}

}
