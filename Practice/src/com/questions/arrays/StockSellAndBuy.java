package com.questions.arrays;

public class StockSellAndBuy {

	public static void main(String[] args) {

		// int a[] = { 100, 180, 260, 310, 40, 535, 695 };
		int a[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println(buyAndSellManyTimes(a));
		System.out.println(buyAndSellOnce(a));
	}

	private static int buyAndSellOnce(int[] a) {
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
			profit = Math.max(profit, a[i] - min);
		}

		return profit;
	}

	private static int buyAndSellManyTimes(int[] a) {
		int profit = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				profit = profit + a[i] - a[i - 1];
			}
		}
		return profit;
	}

}
