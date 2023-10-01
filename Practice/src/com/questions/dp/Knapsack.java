package com.questions.dp;

public class Knapsack {

	public static void main(String[] args) {

		int w[] = { 1, 2, 3, 4, 5, 6 };

		int v[] = { 11, 2, 1, 3, 5, 6 };

		int cap = 66;

		int n = w.length;

		System.out.println(maxProfit(w, v, cap, n));

		System.out.println(maxProfitWithDP(w, v, cap, n));

		System.out.println(maxProfitWithDP1(w, v, cap, n));

	}

	private static int maxProfit(int[] w, int[] v, int cap, int n) {

		if (n == 0 || cap == 0) {
			return 0;
		} else {

			if (w[n - 1] <= cap) {

				return Math.max(v[n - 1] + maxProfit(w, v, cap - w[n - 1], n - 1),

						maxProfit(w, v, cap, n - 1));

			} else {
				return (maxProfit(w, v, cap, n - 1));
			}

		}
	}

	private static int maxProfitWithDP(int[] w, int[] v, int cap, int n) {

		int t[][] = new int[n + 1][cap + 1];
		int i, j = 0;
		// initialization

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= cap; j++) {

				if (i == 0 || j == 0) {
					// initializing first row and first column to zero
					t[i][j] = 0;
				} else if (w[i - 1] <= j) {

					t[i][j] = Math.max(v[i - 1] + t[i - 1][j - w[i - 1]], t[i - 1][j]);

				}

				else {
					t[i][j] = t[i - 1][j];
				}

			}
		}
		return t[n][cap];

	}

	private static int maxProfitWithDP1(int[] w, int[] v, int cap, int n) {

		int t[][] = new int[n][cap + 1];
		int i, j = 0;
		// initialization

		for (i = 0; i < n; i++) {
			for (j = 0; j <= cap; j++) {

				//	System.out.println(i +" "+ j);

				if (j == 0) {
					// Initializing first column to zero, as weight of knapsack is zero.
					t[i][j] = 0;

				} else if (i == 0 && j != 0) {
					// Initializing first column to value of the first element .
					t[i][j] = v[0];
				} else if (w[i] <= j) {

					t[i][j] = Math.max(v[i] + t[i - 1][j - w[i]], t[i - 1][j]);

				}

				else {
					t[i][j] = t[i - 1][j];
				}

			}
		}
		return t[n - 1][cap];

	}
}
