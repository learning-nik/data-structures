package com.important.problems;

public class EncryptString {

	public static void main(String[] args) {

		String s = "aaa";
		int k = 1;
		int n = 6;

		System.out.println(encrypt(s, k, n));

	}

	private static String encrypt(String s, int k, int n) {
		int size = s.length();
		int freq = 1;
		int leftOver = 0;
		if (n > size) {
			freq = n / size;
			leftOver = n % size;
		}

		String answer = s;
		for (int i = 0; i < freq; i++) {
			answer = repeat(answer, k, size);
		}

		if (leftOver != 0) {
			answer = repeat(answer, k, leftOver);
		}

		return answer;

	}

	// z = 122 in integer
	private static String repeat(String s, int k, int n) {

		char[] a = s.toCharArray();

		for (int i = 0; i < n; i++) {

			int changed = a[i] + k;
			if (changed > 122) {
				// as no of chars are 26
				changed = changed - 26;
			}
			a[i] = (char) changed;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]);
		}
		return sb.toString();

	}

}
