package com.questions.stack;

import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {

		//stockSpan();
		StockSpanner spanner = new StockSpanner();
		////[], [100], [80], [60], [70], [60], [75], [85]
		System.out.println(spanner.next(100));
		System.out.println(spanner.next(80));
		System.out.println(spanner.next(60));
		System.out.println(spanner.next(70));
		System.out.println(spanner.next(60));
		System.out.println(spanner.next(75));
		System.out.println(spanner.next(85));

	}

	/*https://www.geeksforgeeks.org/the-stock-span-problem/*/
	private static void stockSpan() {
		int price[] = { 100, 80, 60, 70, 60, 75, 85 };
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < price.length; i++) {
			if (i == 0) {
				System.out.print(1 + ", ");
				stack.push(0);
			} else {
				while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					System.out.print(i + 1 + ", ");
				} else {
					System.out.print(i - stack.peek() + ", ");
				}
				stack.push(i);
			}
		}
	}

	//https://leetcode.com/problems/online-stock-span/description/

	static class StockSpanner {
		Stack<int[]> stack;

		public StockSpanner() {
			stack = new Stack<>();

		}

		//[], [100], [80], [60], [70], [60], [75], [85]
		public int next(int price) {

			int count = 0;
			while (!stack.isEmpty()) {

				int last[] = stack.peek();
				int lastPrice = last[0];

				if (price >= lastPrice) {
					stack.pop();
					count = last[1] + count;
				} else {
					break;
				}

			}
			count++;
			stack.push(new int[] { price, count });

			return count;
		}

	}
}
