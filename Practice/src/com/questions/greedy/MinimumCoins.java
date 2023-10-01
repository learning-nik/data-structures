package com.questions.greedy;

import java.util.Arrays;
import java.util.Collections;

/*https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/?ref=lbp
*/

// https://arunk2.medium.com/coin-exchange-problem-greedy-or-dynamic-programming-6e5ebe5a30b5
// This only works if we have coins of all denominations available , if not then we need to go for DP solution.
// MinCoins  --> dp package
public class MinimumCoins {

	public static void main(String[] args) {

		Integer a[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		// Integer a[] = {9, 6, 5, 1};

		int money = 70;

		Arrays.sort(a, Collections.reverseOrder());

		int count = 0;
		int finalCount = Integer.MAX_VALUE;

		int collection = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] < money) {
				collection = a[i];
				count = 1;
				i++;
				while (i < a.length) {
					if (a[i] + collection <= money) {
						collection = a[i] + collection;
						count++;
					}

					if (collection == money && finalCount > count) {
						finalCount = count;
					}
					i++;
				}
			}
		}
		System.out.println(finalCount);
	}
}
