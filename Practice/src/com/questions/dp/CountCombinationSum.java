package com.questions.dp;

public class CountCombinationSum {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3 ,4};
		//int nums[] = { 9 };
		//int nums[] = { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		int target = 4;

		int answer = combinationSum4(nums, target);
		System.out.println(answer);

		//LCS.printArray(nums.length, nums[0].length, nums);
	}

	// Now working
	public static int combinationSum4(int[] nums, int target) {

		int m = nums.length;
		int n = target;

		int dp[][] = new int[m + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			if (i % nums[0] != 0) {
				dp[0][i] = 0;
			} else {
				dp[0][i] = 1;
			}
		}

		// First column is zero
		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (j >= nums[i - 1]) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i - 1]];

				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}

		}

		LCS.printArray(m, n, dp);

		return dp[m][n];
	}

}
