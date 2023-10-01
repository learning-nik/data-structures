package com.questions.string;
// DSA videos
// Check if S2 is Subsequence of S1.
public class SubSequence {

	public static void main(String[] args) {
		String s1 = "abcdep";
		String s2 = "af";
		System.out.println(checkIfSubSequence(s1, s2));
	}

	private static boolean checkIfSubSequence(String s1, String s2) {
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}
		return (j==s2.length());
	}

}
