package com.questions.matrix;

public class MaxSumFromEachRow {

	public static void main(String[] args) {

		int a[][] = { { 4, 6, 1 }, { 2, 5, 7 }, { 9, 1, 2 } };

		int sum = maxSumFromRow(a);
		System.out.println(sum);

	}

	private static int maxSumFromRow(int[][] a) {

		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = 0; j < a[i].length; j++) {
				sum = sum + a[i][j];
			}
			maxSum = Math.max(maxSum, sum);
		}

		return maxSum;
	}

}
