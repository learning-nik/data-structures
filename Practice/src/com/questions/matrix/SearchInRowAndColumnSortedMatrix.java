package com.questions.matrix;

// Each row is sorted and each column is sorted
//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchInRowAndColumnSortedMatrix {

	public static void main(String[] args) {

		int a[][] = { { 1, 5, 9 }, { 2, 6, 10 }, { 3, 7, 11 } };
		print(a);
		System.out.println(searchMatrix(a, 33));
	}

	public static boolean searchMatrix(int[][] a, int target) {

		int row = 0;
		int col = a[0].length - 1;

		boolean isPresent = false;

		// initial pointer is at first row and last column

		while (row < a.length && col >= 0) {

			if (a[row][col] == target) {
				return true;
			} else if (target < a[row][col]) {
				col--;
			} else {
				row++;
			}
		}

		return isPresent;
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
