package com.questions.string;

//https://leetcode.com/problems/decode-string/description/
public class DecodeString {

	public static void main(String[] args) {

		//String s = "3[a]2[bc]";

		String s = "2[abc]3[cd]ef";

		//System.out.println(index);
		System.out.println(decodeString(s));
	}

	public static String decodeString(String s) {

		String result = "";

		for (int i = 0; i < s.length(); i++) {

			if (Character.isDigit(s.charAt(i))) {
				int count = Integer.parseInt(String.valueOf(s.charAt(i)));

				int k = i + 2;
				String sub = "";
				while (s.charAt(k) != ']') {

					sub += s.charAt(k);
					k++;
				}

				System.out.println(sub);
				System.out.println(count);

				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < count; j++) {
					sb.append(sub);
				}
				//System.out.println(sub);

				result = result + sb.toString();

				i = i + k;
			} else {
				result = result + s.charAt(i);
			}
		}

		return result;

	}

}
