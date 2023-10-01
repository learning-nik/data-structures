package com.questions.string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
public class LongestSubstring {

	public static void main(String[] args) {

		//String s = "abcabcbb";
		//String s = "aaaa";
		//String s = "abba";
		String s = "abcabcbb";

		System.out.println(lengthOfLongestSubstring(s));

	}

	public static int lengthOfLongestSubstring(String s) {

		int maxLength = Integer.MIN_VALUE;
		int left = 0;
		int right = 1;

		Map<Character, Integer> map = new HashMap<>();
		map.put(s.charAt(0), 0);

		while (right < s.length()) {

			if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {

				int leftIndex = map.get(s.charAt(right));
				left = leftIndex + 1;
				map.remove(s.charAt(right));

			} else {
				map.put(s.charAt(right), right);

				int currLength = right - left + 1;
				if (currLength > maxLength) {
					maxLength = currLength;
				}

				right++;

			}

		}

		return maxLength;

	}

}
