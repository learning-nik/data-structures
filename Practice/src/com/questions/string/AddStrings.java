package com.questions.string;

public class AddStrings {

	public static void main(String[] args) {

		String num1 = "11";
		String num2 = "123";

		// 456
		/*String num1 = "456";
		String num2 = "77";*/

		/*String num1 = "1";
		String num2 = "9";*/

		//System.out.println(addStrings(num1, num2));

		/*String s1 = "1,2,3";
		String s2 = "9,1";*/

		//"  1" ,
		//"1,2"

		String s1 = "6,9,9";
		String s2 = "1,0,0";

		System.out.println(addStringsWithComma(s1, s2));

	}

	private static String addStringsWithComma(String num1, String num2) {

		int m = num1.length() - 1;
		int n = num2.length() - 1;

		int carry = 0;
		int sum = 0;
		StringBuilder sb = new StringBuilder();

		while (m >= 0 || n >= 0) {

			boolean isComma = false;
			sum = 0;

			if (m >= 0) {
				if (num1.charAt(m) == ',') {
					m--;
					isComma = true;

				} else {
					sum = sum + (num1.charAt(m--) - '0');
				}
			}

			if (n >= 0) {
				if (num2.charAt(n) == ',') {
					n--;
					isComma = true;
				} else {
					sum = sum + (num2.charAt(n--) - '0');
				}
			}

			if (!isComma) {
				sum = sum + carry;
				carry = sum / 10;
				sum = sum % 10;
				sb.append(sum + ",");
			}

		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

	public static String addStrings(String num1, String num2) {

		int m = num1.length() - 1;
		int n = num2.length() - 1;

		int carry = 0;
		int sum = 0;
		StringBuilder sb = new StringBuilder();

		while (m >= 0 || n >= 0) {

			sum = 0;

			if (m >= 0) {
				sum = sum + (num1.charAt(m--) - '0');
			}

			if (n >= 0) {
				sum = sum + (num2.charAt(n--) - '0');
			}

			sum = sum + carry;
			carry = sum / 10;
			sum = sum % 10;

			sb.append(sum);

		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

	private static String addStringsWithComma2(String num1, String num2) {

		int m = num1.length() - 1;
		int n = num2.length() - 1;
		int sum = 0;
		int carry = 0;

		StringBuilder sb = new StringBuilder();

		while (m >= 0 || n >= 0) {
			sum = 0;

			if (m >= 0) {

				while (m >= 0 && num1.charAt(m) == ',') {
					m--;
				}

				if (m >= 0)
					sum = sum + num1.charAt(m--) - '0';

			}

			if (n >= 0) {

				while (n >= 0 && num2.charAt(n) == ',') {
					n--;
				}
				if (n >= 0)
					sum = sum + num2.charAt(n--) - '0';
			}

			sum = sum + carry;
			carry = 0;

			if (sum >= 10) {
				carry = sum / 10;
				sum = sum % 10;
			}

			sb.append(sum);

		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();

	}

}
