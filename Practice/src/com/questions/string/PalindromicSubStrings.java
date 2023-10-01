package com.questions.string;

public class PalindromicSubStrings {

	public static void main(String[] args) {

		//String s = "abbac";

		String s = "dbabcccbcdbbbadabbdabaabcbbabaacdadcdbbbbdddbcbbbcbcabacacdaadaadcdccbacdaadadcbaacabbddabdadcabbccadacadaaacbbddaaababacaabbbacaccbcbbabddbbcccaaacbcdcabcbacdbddcdcadaaadcbccbbcabbcbdaadcbddaacacdadacbbdabcdcdadccaccdbdddddcabdbcdbaadacadadbabdcdbbadaacdbadcdabdbbcabbbdaacaaaaadcaabaaaadabaaddcaabdddcbcadcbdbbdbcbcdbadcadacbbcdccddaccccacbacaacbbdadadcacabdabadbbcdbcaaccdbdcabcadbacbccddbabbdacbcbbcbcabcacdaacccaadcdbdccabcaaacaddadcabacdccaaaddaaadbccdbbcccdddababcdbcddcbdddbbbdaadaccbcaabbcbdbadbabbacdbbbdaaccdcabddacadabcccacdabacbcdbcbdabddacacbdbcaacacaabbaaccddabaadbbaabaddbcacbacdbbbacdccabbcdbbbdbdbbcacabdddbdbaaabbcdcbabcbbbccdcdcdcaaddadccbabbacaddcaddcadcdccaccacabbaababdbbcbdcdccccccdadbdbdcdbdadcdcacdaabaacabaacdacdbaaccadbcddbdccabbcabcadcbdadbcdadbbbccacbcbbcaaaabdacbadacaadcadaacdacddcbbabdacacaabccdaccbbcbbcbcaacdabdcbcdbccdbcbcbddaacdacaaaddcaddcadccacbaddbbbccbbbcbbcbadcabbccbbaadaacacabddbdbddcadbdaaccadbcccabdcdbadbbacbcbbcdcabcddcddddabddbdabdcabdbdbbbcdbcdabbdcb";

		//System.out.println(countSubstrings(s));

		System.out.println(longestPalindrome(s));

	}

	// Given a string s, return the number of palindromic substrings in it.
	//https://leetcode.com/problems/palindromic-substrings/submissions/
	//https://www.youtube.com/watch?v=XmSOWnL6T_I
	private static int countSubstrings(String s) {

		int[][] dp = new int[s.length()][s.length()];

		int count = 0;

		for (int g = 0; g < s.length(); g++) {

			for (int i = 0, j = g; i < s.length() && j < s.length(); i++, j++) {

				// If gap is zero ,which means single string is always palindrome

				if (g == 0) {
					dp[i][j] = 1;
					count++;
				}

				// If gap is one ,which means string of length 2 
				// if both chars are equal then string is palindrome	
				else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 1;
						count++;
					}

				}
				// check if the first and the last character is equal
				// if true , check the remaining string 
				else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					count++;
				}

			}
		}

		return count;

	}

	// Given a string s, return the longest palindromic substring in s.
	// https://leetcode.com/problems/longest-palindromic-substring/
	private static String longestPalindrome(String s) {

		int[][] dp = new int[s.length()][s.length()];

		String output = "";

		//	int count = 0;

		for (int g = 0; g < s.length(); g++) {

			for (int i = 0, j = g; i < s.length() && j < s.length(); i++, j++) {

				// If gap is zero ,which means single string is always palindrome

				if (g == 0) {
					dp[i][j] = 1;
					output = s.substring(i, j + 1);

				}

				// If gap is one ,which means string of length 2 
				// if both chars are equal then string is palindrome	
				else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 1;
						output = s.substring(i, j + 1);
					}

				}
				// check if the first and the last character is equal
				// if true , check the remaining string 
				else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					output = s.substring(i, j + 1);
				}

			}
		}

		return output;

	}

}
