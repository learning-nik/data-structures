package com.important.problems;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {

	public static void main(String[] args) {

		String s = "NITIN";
		//String s = "abccccdd";

		//String s = "A man, a plan, a canal: Panama";

		//String s = "race a car";

		//System.out.println(isPalindromeWithoutAlphanumericals(s));

		System.out.println(checkIfPalindrome(s));
		System.out.println(checkIfPalindromeIterative(s));
		System.out.println(checkIfPalindromeRecursive(s));
		//System.out.println(longestPalindrome(s));

	}

	private static boolean checkIfPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString().equals(s);

	}

	private static boolean checkIfPalindromeIterative(String s) {

		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}

		return true;
	}

	private static boolean checkIfPalindromeRecursive(String s) {

		return recursive(s, 0 , s.length()-1);

	}

	private static boolean recursive(String s, int left, int right) {

		if (left >= right) {
			return true;
		}

		if (s.charAt(left) != s.charAt(right)) {
			return false;
		}

		return recursive(s, left + 1, right - 1);

	}

	//https://leetcode.com/problems/longest-palindrome/solution/
	public static int longestPalindrome(String s) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}

		}

		System.out.println(map);

		int count = 0;
		boolean containsOdd = false;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {

			if (entry.getValue() % 2 == 0) {
				// count is even
				count = count + entry.getValue();
			} else {
				containsOdd = true;
				count = count + ((entry.getValue() / 2) * 2);
			}
		}

		if (containsOdd) {
			count = count + 1;
		}

		return count;

	}

	// https://leetcode.com/problems/valid-palindrome/
	// length of longest palindrome that can be made from a string 
	public static boolean isPalindromeWithoutAlphanumericals(String s) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				// Character.toLowerCase(c);
				sb.append(Character.toLowerCase(c));
			}
		}

		//System.out.println(sb.toString());
		String orig = sb.toString();
		String rev = sb.reverse().toString();
		return orig.equals(rev);

	}

}
