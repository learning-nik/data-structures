package com.questions.matrix;

public class SearchInFullSortedMatrix {

	public static void main(String[] args) {

		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print(a);
		search(a, 8);
	}

	private static boolean search(int[][] a, int element) {

		int n = a.length;
		int m = a[0].length;
		int left = 0;
		int right = (n * m) - 1;

		while (left <= right) {
			int mid = left + ((right - left) / 2);
			int x = mid / m;
			int y = mid % m;
			if (element == a[x][y]) {
				System.out.println("FOUND at " + x + "," + y);
				return true;
			} else if (element > a[x][y]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	private static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
