package com.questions.dp;

/*https://www.geeksforgeeks.org/min-cost-path-dp-6/
*/
public class MinimumCostPath {

	public static void main(String[] args) {

		int a[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		minPathSum(a);

		//printArray(cost);

		//System.out.println(uniquePaths(3, 2));

	}

	//https://leetcode.com/problems/minimum-path-sum/
	public static int minPathSum(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		int dp[][] = new int[m][n];

		dp[0][0] = grid[0][0];

		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}

		for (int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {

				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		printArray(dp);

		return dp[m - 1][n - 1];
	}

	private static void printArray(int[][] a) {
		System.out.println("------------");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

	// https://leetcode.com/problems/unique-paths/
	public static int uniquePaths(int m, int n) {

		int dp[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}

		// printArray(dp);

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {

				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];

			}
		}

		return dp[m - 1][n - 1];
	}

	public static int uniquePathsBetterCode(int m, int n) {

		int dp[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				// Set the first row and column to 1
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {

					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}

			}
		}

		return dp[m - 1][n - 1];
	}

}
