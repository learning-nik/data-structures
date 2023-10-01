package com.questions.dp;

//https://leetcode.com/problems/partition-equal-subset-sum/
// https://www.youtube.com/watch?v=34l1kTIQCIA
public class SubSetSum {

	public static void main(String[] args) {

		// int a[] = { 1, 5, 11, 5 };

		int a[] = { 1, 5, 11, 5 };
		// int target = 40;

		System.out.println(canPartition(a));

	}

	public static boolean canPartition(int[] a) {

		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}

		if (sum % 2 != 0) {
			return false;
		}

		return checkIfSubSetContainsTarget(a, sum / 2);
	}

	public static boolean checkIfSubSetContainsTarget(int[] a, int target) {

		int m = a.length;
		int n = target;
		boolean dp[][] = new boolean[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (dp[i - 1][j]) {
					dp[i][j] = true;
				} else {

					if (a[i - 1] <= j) {

						if (dp[i - 1][j - a[i - 1]]) {
							dp[i][j] = true;
						}
					}
				}

			}
		}

		return dp[m][n];

	}

}
