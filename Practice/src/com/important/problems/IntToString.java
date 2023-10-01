package com.important.problems;

public class IntToString {

	public static void main(String[] args) {

		int n = 1235;
		convertToString(n);

		/*String s = "123";
		convertToInteger(s);*/

	}

	private static void convertToInteger(String s) {

		int num = 0;
		int factor = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			int cur = s.charAt(i) - '0';
			num = num + cur * factor;
			factor = factor * 10;
		}

		System.out.println(num);
	}

	private static void convertToString(int n) {

		StringBuilder sb = new StringBuilder();
		int rem = 0;
		while (n != 0) {
			// 123 %10 = 3 = last digit
			rem = n % 10;
			sb.append(rem);
			// 123/10 = 12 = remove the last digit
			n = n / 10;
		}
		System.out.println(sb.reverse());
	}

}
