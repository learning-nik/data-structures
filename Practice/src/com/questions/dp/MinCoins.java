package com.questions.dp;

public class MinCoins {
	//https://leetcode.com/problems/coin-change/
	//https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-DP/video/MTEzNw%3D%3D
	public static void main(String[] args) {

		//int coins[] = { 1, 2, 3, 4 };
		//int coins[] = { 3, 6, 3 };

		int coins[] = { 1, 2, 5 };
		int value = 3;

		//minCoins(coins, value);

		//677
		//29

		/*int coins[] = { 285, 133, 540, 753, 333, 6, 470, 156, 415, 182, 612, 114, 114, 727, 575, 395, 262, 821, 941,
				499, 627, 955, 165, 728, 355, 844, 850, 99, 931 };*/

		System.out.println(minimumNumberOfCoins2(coins, 3, 3));

		System.out.println(minimumNumberOfCoinsSpaceOpt(coins, 3, 3));

		//System.out.println(minCoins(coins, 677));
		//System.out.println(minCoins(coins, 4));

	}

	static long minimumNumberOfCoins2(int coins[], int numberOfCoins, int value) {

		int m = numberOfCoins;
		int n = value;

		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			dp[0][i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (j >= coins[i - 1]) {

					if (dp[i][j - coins[i - 1]] == Integer.MAX_VALUE) {
						dp[i][j] = dp[i - 1][j];
					} else {
						// Min between including the coin or excluding it.
						dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
					}

				} else {
					// Exclude the coin and keep the sum same.
					dp[i][j] = dp[i - 1][j];
				}

			}
		}

		//LCS.printArray(m, n, dp);

		return dp[m][n] == Integer.MAX_VALUE ? -1 : dp[m][n];

	}

	static long minimumNumberOfCoinsSpaceOpt(int coins[], int numberOfCoins, int value) {

		int dp[] = new int[value + 1];
		// When amount is zero , no coins are needed   
		dp[0] = 0;

		for (int i = 1; i < dp.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {

				// If Amount(i) > Value of Coin
				if (i >= coins[j]) {

					if (dp[i - coins[j]] != Integer.MAX_VALUE) {
						min = Math.min(1 + dp[i - coins[j]], min);

					}

				}
			}
			dp[i] = min;
		}

		return dp[value] == Integer.MAX_VALUE ? -1 : dp[value];
	}
}
