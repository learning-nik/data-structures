package com.important.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class LetterCombinations {

	private final Map<Character, String> map = buildMap();

	public static void main(String[] args) {

		List<String> list = new LetterCombinations().letterCombinations("23");
		System.out.println(list);
	}

	public List<String> letterCombinations(String digits) {

		List<String> list = new ArrayList<>();

		if (digits == null || digits.length() == 0)
			return list;

		backtrack(digits, list, 0, "");

		return list;

	}

	private void backtrack(String digits, List<String> list, int index, String res) {

		if (res.length() == digits.length()) {
			list.add(res);
			return;
		}

		String letter = map.get(digits.charAt(index));
		for (int i = 0; i < letter.length(); i++) {
			String newStr = res + letter.charAt(i);
			backtrack(digits, list, index + 1, newStr);
		}

	}

	private Map<Character, String> buildMap() {
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		return map;
	}

}
