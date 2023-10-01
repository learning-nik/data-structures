package com.questions.string;

//https://leetcode.com/problems/add-binary/
public class AddBinary {

	public static void main(String[] args) {

		/*String s1 = "1010";
		String s2 = "1011";*/

		String s1 = "1";
		String s2 = "111";

		System.out.println(addBinary(s1, s2));

	}

	private static String addBinary(String a, String b) {

		int carry = 0;
		int sum = 0;

		int i = a.length() - 1;
		int j = b.length() - 1;

		StringBuilder sb = new StringBuilder();

		while (i >= 0 || j >= 0) {
			sum = carry;
			if (i >= 0) {
				int one = Character.getNumericValue(a.charAt(i));
				sum = sum + one;
				i--;
			}

			if (j >= 0) {
				int two = Character.getNumericValue(b.charAt(j));
				sum = sum + two;
				j--;
			}

			carry = sum / 2;
			sb.append(sum % 2);
		}
		if (carry == 1) {
			sb.append(carry);
		}

		return sb.reverse().toString();

	}

}
