package com.questions.string;

public class EncodeString {

	public static void main(String[] args) {

		String s = "aabca";

		encodeString(s);

	}

	private static void encodeString(String s) {

		int i = 0;
		int j = 0;
		int count = 0;
		StringBuilder builder = new StringBuilder();
		while (j < s.length()) {

			if (s.charAt(i) == s.charAt(j)) {
				count++;
				j++;

			} else {
				builder.append(s.charAt(i));
				builder.append(count);
				count = 0;
				i = j;

			}
		}
		
		// This is done for last character , as j is more than length in this case and it exits the while loop
		builder.append(s.charAt(i));
		builder.append(count);

		System.out.println(builder.toString());

	}

}
