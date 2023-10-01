package com.important.problems;

// Fib Series is : 0 , 1 , 1 , 2 , 3 , 5 , 8 ...
// Find Nth Fib num
public class Fibonacci {

	int[][] A = new int[2][2];

	public static void main(String[] args) {

		int n = 10;

		System.out.println(fibonacciRecurssion(n));
		System.out.println(fibonacciDP(n));
		System.out.println(fibonacciOptimised(n));
		System.out.println(new Fibonacci().fib(n));
	}
	
	// O(n) time
	// O(n) space ?
	public static int fibonacciRecurssion(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		return fibonacciRecurssion(n - 1) + fibonacciRecurssion(n - 2);

	}

	// O(n) time
	// O(n) space
	public static int fibonacciDP(int n) {

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];

	}

	// O(n) time
	// O(1) space
	private static int fibonacciOptimised(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int last = 1;
		int secondLast = 0;

		int current = 1;
		for (int i = 2; i <= n; i++) {

			current = last + secondLast;
			secondLast = last;
			last = current;

		}

		return current;
	}

	// in logn time
	// https://www.youtube.com/watch?v=e-sbCk5FOF8

	public int fib(int n) {
		if (n <= 1) {
			return n;
		}

		// build base matrix 
		// [ 1 1 ]
		// [ 1 0 ]

		A[0][0] = 1;
		A[1][0] = 1;
		A[0][1] = 1;
		A[1][1] = 0;

		int[][] answer = helper(n);

		return answer[1][0];
	}

	public int[][] helper(int current) {
		if (current == 1) {
			return A;
		}
		int[][] temp = helper(current / 2);
		if (current % 2 == 0) {
			return multiply(temp, temp);
		} else {
			return multiply(multiply(temp, temp), A);
		}
	}

	public int[][] multiply(int[][] A, int[][] B) {
		int[][] result = new int[2][2];
		result[0][0] = A[0][0] * B[0][0] + A[1][0] * B[0][1];
		result[1][0] = A[0][0] * B[1][0] + A[1][0] * B[1][1];
		result[0][1] = A[0][1] * B[0][0] + A[1][1] * B[1][0];
		result[1][1] = A[0][1] * B[1][0] + A[1][1] * B[1][1];
		return result;
	}

}
