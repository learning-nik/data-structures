package com.questions.string;

// First Repeating Character from Left
// DSA Videos
public class LeftMostRepeatingCharacter {

	public static void main(String[] args) {

		String s = "abcdefb";

		System.out.println(indexUsingMethod1(s));
		System.out.println(indexUsingMethod2(s));
	}

	// Go through the String left to right 2 times.
	private static int indexUsingMethod1(String s) {
		int count[] = new int[128];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i)] > 1) {
				return i;
			}
		}
		return -1;
	}

	// Go from right to left.
	private static int indexUsingMethod2(String s) {

		boolean count[] = new boolean[128];
		int resultIndex = -1;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (count[s.charAt(i)] == false) {
				count[s.charAt(i)] = true;
			} else {
				resultIndex = i;
			}
		}
		return resultIndex;
	}

}
