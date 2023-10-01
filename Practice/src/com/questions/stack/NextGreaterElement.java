package com.questions.stack;

import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

	public static void main(String[] args) {

		//long arr[] = { 6, 8, 0, 1, 3 };

		/*long arr[] = { 1, 2, 3, 4 };
		
		long[] ans = nextLargerElement(arr, arr.length);
		*/

		int a[] = { 73, 74, 75, 71, 69, 72, 76, 73 };

		int ans[] = dailyTemperatures(a);

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	// long arr[] = { 6, 8, 0, 1, 3 };

	public static long[] nextLargerElement(long[] a, int n) {

		long answer[] = new long[a.length];
		Arrays.fill(answer, -1);

		// Add the last element to the stack
		Stack<Long> stack = new Stack<>();
		stack.push(a[n - 1]);

		// Traverse from last to first
		// if element is stack is more than the current element , then its the next greater element.
		//  otherwise traverse through the stack and check if any element is greater than current.
		// finally add current to stack.

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] < stack.peek()) {
				answer[i] = stack.peek();
			} else {
				while (!stack.isEmpty()) {
					Long lastElement = stack.peek();
					if (a[i] < lastElement) {
						answer[i] = lastElement;
						break;
					} else {
						stack.pop();
					}
				}

			}
			stack.push(a[i]);
		}

		return answer;

	}

	//https://leetcode.com/problems/daily-temperatures/description/

	public static int[] dailyTemperatures(int[] a) {
		// Similar to next greater element
		int n = a.length;
		int answer[] = new int[a.length];
		Stack<Integer> stack = new Stack<>();
		// add the index of last element
		stack.push(n - 1);

		for (int i = n - 2; i >= 0; i--) {

			if (a[i] < a[stack.peek()]) {
				answer[i] = stack.peek() - i;
			} else {
				while (!stack.isEmpty()) {

					Integer lastElement = a[stack.peek()];
					if (a[i] < lastElement) {
						answer[i] = stack.peek() - i;
						break;
					} else {
						stack.pop();
					}
				}
			}
			stack.push(i);
		}

		return answer;
	}
}
