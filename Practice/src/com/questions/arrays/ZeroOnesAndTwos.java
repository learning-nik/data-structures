package com.questions.arrays;
//https://leetcode.com/problems/sort-colors/
public class ZeroOnesAndTwos {

	public static void main(String[] args) {

		//int a1[] = { 2, 1, 1, 2, 1, 0 };
		int a1[] = { 0, 1, 2, 0, 1, 2 };
		//sort(a1);
		sortColors(a1);
		print(a1);
	}

	public static void sort(int[] a1) {
		int low = 0;
		int mid = 0;
		int high = a1.length - 1;

		while (mid <= high) {
			if (a1[mid] == 0) {
				swap(mid, low, a1);
				low++;
				mid++;
			}

			if (a1[mid] == 1 && mid <= high) {
				mid++;
			}

			if (a1[mid] == 2 && mid <= high) {
				swap(mid, high, a1);
				high--;
			}
		}
	}

	public static void sortColors(int[] a) {

		int left = 0;
		int right = a.length - 1;
		int mid = 0;

		while (mid <= right) {

			if (a[mid] == 0) {
				swap(mid, left, a);
				left++;
				mid++;
			}

			else if (a[mid] == 1) {
				mid++;
			} else {
				swap(mid, right, a);
				right--;
			}

		}

	}

	private static void print(int[] a1) {
		for (int element : a1) {
			System.out.print(element + " ");
		}
	}

	private static void swap(int i, int j, int a1[]) {
		int temp;

		temp = a1[i];
		a1[i] = a1[j];
		a1[j] = temp;
	}

}
