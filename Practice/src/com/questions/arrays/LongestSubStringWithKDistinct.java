package com.questions.arrays;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
// length of longest substring with atmost k distinct characters
public class LongestSubStringWithKDistinct {

	public static void main(String[] args) {

		/*String s = "babccccc";
		int k = 2;
		System.out.println(kDistinctChars(k, s));*/

		/*String s = "aabacbebebe";
		int k = 3;*/

		String s = "abcdefgh";
		int k = 2;

		//aabacbebebe

		System.out.println(longestkSubstr(s, k));
	}

	//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
	// exactly k distinct
	public static int longestkSubstr(String s, int k) {

		// a b c d e f h
		int left = 0;
		int right = 0;
		int answer = 0;
		Map<Character, Integer> map = new HashMap<>();

		while (right < s.length()) {

			char toBeAdded = s.charAt(right);
			map.put(toBeAdded, map.getOrDefault(toBeAdded, 0) + 1);

			System.out.println(map);

			if (map.size() == k) {
				answer = Math.max(answer, right - left + 1);
			}

			if (map.size() > k) {
				while (map.size() > k && left <= right) {
					updateMap(map, s.charAt(left));
					left++;
				}
			}
			right++;

		}

		return answer;

	}

	// reduce/remove entry from map
	static void updateMap(Map<Character, Integer> map, char toBeRemoved) {

		if (map.get(toBeRemoved) == 1) {
			map.remove(toBeRemoved);
		} else {
			map.put(toBeRemoved, map.get(toBeRemoved) - 1);
		}
	}

	// atmost k distinct chars
	public static int kDistinctChars(int k, String s) {

		int left = 0;
		int right = 0;
		int answer = 0;
		Map<Character, Integer> map = new HashMap<>();

		while (right < s.length()) {

			char toBeAdded = s.charAt(right);

			map.put(toBeAdded, map.getOrDefault(toBeAdded, 0) + 1);

			if (map.size() > k) {

				while (map.size() > k && left <= right) {
					updateMap(map, s.charAt(left));
					left++;
				}

			} else {
				answer = Math.max(answer, right - left + 1);
				right++;
			}

		}

		return answer;

	}

}
