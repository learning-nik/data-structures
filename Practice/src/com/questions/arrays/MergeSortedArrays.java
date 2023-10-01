package com.questions.arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {

		int a[] = { 1, 4, 6, 7, 108 };
		int b[] = { 2, 3, 5, 9, 11, 99, 103 };

		//mergeArraysWithExtraSpace(a, b);

		int nums1[] = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int nums2[] = { 2, 5, 6 };
		int n = 3;

		new MergeSortedArrays().merge(nums1, m, nums2, n);
	}

	private static void mergeArraysWithExtraSpace(int a[], int b[]) {
		int l1 = a.length;
		int l2 = b.length;
		int c[] = new int[l1 + l2];

		int x = 0;
		int y = 0;
		int z = 0;

		while (x < l1 && y < l2) {

			if (a[x] < b[y]) {
				c[z++] = a[x++];
			}

			else if (a[x] > b[y]) {
				c[z++] = b[y++];
			}

			else if (a[x] == b[y]) {
				c[z++] = a[y++];
				x++;
			}
		}

		if (x != l1) {
			for (int i = x; i < l1; i++) {
				c[z++] = a[i];
			}
		} else if (y != l2) {
			for (int i = y; i < l2; i++) {
				c[z++] = b[i];
			}
		}

		for (int i = 0; i < l1 + l2; i++) {
			System.out.print(c[i] + " ");
		}

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int index = m + n - 1;
		int i = m - 1;
		int j = n - 1;

		while (i >= 0 && j >= 0) {

			if ((nums1[i] > nums2[j])) {
				nums1[index--] = nums1[i--];
			} else {
				nums1[index--] = nums2[j--];
			}
		}
		while (j >= 0) {
			nums1[index--] = nums2[j--];
		}

	}

}
