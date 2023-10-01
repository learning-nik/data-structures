package com.questions.dp;

public class LCS {

	public static void main(String[] args) {

		String str1 = "ABCDGH";
		String str2 = "AEDFHR";

		System.out.println(LCSUsingDP(str1, str2));

	}

	private static int LCSUsingDP(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();

		int dp[][] = new int[m + 1][n + 1];

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		printArray(m, n, dp);

		return dp[m][n];

	}

	public static void printArray(int m, int n, int[][] dp) {
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print(dp[i][j] +"   ");
			}
			System.out.println();
		}
	}

}
