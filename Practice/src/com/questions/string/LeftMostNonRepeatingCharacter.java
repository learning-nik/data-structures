package com.questions.string;

// First Non repeating character from left.
public class LeftMostNonRepeatingCharacter {

	public static void main(String[] args) {

		String s = "abcdea";
		System.out.println(indexUsingMethod1(s));
	}

	// Go through the String left to right 2 times. 
	private static int indexUsingMethod1(String s) {
		int count[] = new int[128];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i)] == 1) {
				return i;
			}
		}
		return -1;
	}

}
