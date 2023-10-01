package com.questions.dp;

//https://leetcode.com/problems/edit-distance/description/
// Min operations to make string equal
// DSA videos explanation
public class EditDistance {

	public static void main(String[] args) {

		//String s1 = "CAT";
		//String s2 = "CUT";

		//String s1 = "SATURDAY";
		//String s2 = "SUNDAY";

		String s1 = "horse";
		String s2 = "ros";

		System.out.println(minimumChanges(s1, s2, s1.length(), s2.length()));

		System.out.println(minimumChangesWithDP(s1, s2, s1.length(), s2.length()));

		System.out.println(minDistance(s1, s2));

	}

	private static int minimumChanges(String s1, String s2, int m, int n) {

		// if any of the string is empty then return the length of other string
		if (m == 0) {
			return n;
		}

		if (n == 0) {
			return m;
		}

		// IF last character is same , no changes are needed
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return minimumChanges(s1, s2, m - 1, n - 1);
		}

		else {
			// Compare Min between
			// Adding a character, removing a character, or updating a character.
			int min1 = Math.min(minimumChanges(s1, s2, m - 1, n - 1), minimumChanges(s1, s2, m - 1, n));
			int min2 = Math.min(minimumChanges(s1, s2, m - 1, n - 1), minimumChanges(s1, s2, m, n - 1));

			return 1 + Math.min(min1, min2);
		}
	}

	private static int minimumChangesWithDP(String s1, String s2, int m, int n) {

		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j < n + 1; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int min1 = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
					int min2 = Math.min(dp[i - 1][j], dp[i][j - 1]);
					dp[i][j] = 1 + Math.min(min1, min2);
				}
			}
		}

		return dp[m][n];
	}

	public static int minDistance(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();

		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = i;
		}

		for (int i = 0; i < n + 1; i++) {
			dp[0][i] = i;
		}

		//print(dp);

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}

			}
		}

		//print(dp);

		return dp[m][n];

	}

	private static void print(int a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + ", ");
			}
			System.out.println();
		}

	}
}
