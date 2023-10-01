package com.questions.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DSA videos
public class Anagrams {

	public static void main(String[] args) {

		/*String s1 = "listen";
		String s2 = "silent";
		System.out.println(checkIfAnagramsUsingMap(s1, s2));
		System.out.println(checkIfAnagramsUsingArray(s1, s2));
		System.out.println(checkIfAnagramsUsingOneMap(s1, s2));*/

		String s[] = { "eat", "tea", "tan", "ate", "nat", "bat" };

		System.out.println(groupAnagrams(s));
		System.out.println(groupAnagramsWithoutSorting(s));

		//findAnagrams("cbaebabacd", "abc").forEach(a -> System.out.println(a));

	}

	//Using Character Array
	// TC : O(N)
	private static boolean checkIfAnagramsUsingArray(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}

		int count[] = new int[128];

		for (int i = 0; i < s1.length(); i++) {

			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				return false;
			}
		}

		return true;
	}

	// Using 2 Maps
	// TC : O(N)
	private static boolean checkIfAnagramsUsingMap(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			Character c = s1.charAt(i);
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < s2.length(); i++) {
			Character c = s2.charAt(i);
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}

		return map1.equals(map2);
	}

	// Using 1 Map
	// TC : O(N)
	// Put the chars of string 1 in map and then remove the characters of string 2 from same map , 
	// finally map should be empty
	private static boolean checkIfAnagramsUsingOneMap(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}
		Map<Character, Integer> map1 = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			Character c = s1.charAt(i);
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < s2.length(); i++) {
			Character c = s2.charAt(i);
			Integer value = map1.get(c);

			if (value != null) {

				if (value == 1) {
					map1.remove(c);
				} else {
					map1.put(c, map1.get(c) - 1);
				}

			}
		}

		return map1.isEmpty();
	}

	//	https://leetcode.com/problems/group-anagrams/
	// TC : N * k Log K where N = length of array and K is the length of individual String
	public static List<List<String>> groupAnagrams(String[] s) {

		Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < s.length; i++) {

			char[] a = s[i].toCharArray();
			Arrays.sort(a);
			String sorted = new String(a);

			if (map.containsKey(sorted)) {

				List<String> oldList = map.get(sorted);
				List<String> updated = new ArrayList<>(oldList);
				updated.add(s[i]);

				map.put(sorted, updated);

			} else {
				map.put(sorted, Arrays.asList(s[i]));
			}

		}

		List<List<String>> mainList = new ArrayList<>();

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {

			mainList.add(entry.getValue());
		}

		return mainList;
	}

	// TC : N * K where K = length of individual String
	public static List<List<String>> groupAnagramsWithoutSorting(String[] s) {

		Map<Map<Character, Integer>, List<String>> mainMap = new HashMap<>();

		for (int i = 0; i < s.length; i++) {

			Map<Character, Integer> frequencyMap = calculateFrequency(s[i]);

			if (mainMap.containsKey(frequencyMap)) {

				List<String> oldList = mainMap.get(frequencyMap);
				List<String> updated = new ArrayList<>(oldList);
				updated.add(s[i]);
				mainMap.put(frequencyMap, updated);

			} else {
				mainMap.put(frequencyMap, Arrays.asList(s[i]));
			}

		}

		List<List<String>> mainList = new ArrayList<>();

		for (Map.Entry<Map<Character, Integer>, List<String>> entry : mainMap.entrySet()) {

			mainList.add(entry.getValue());
		}

		return mainList;
	}

	//https://leetcode.com/problems/find-all-anagrams-in-a-string/
	// TC : N * K 
	public static List<Integer> findAnagrams(String s, String p) {

		// edge cases
		if (p.length() > s.length()) {
			return new ArrayList<>();
		}

		List<Integer> list = new ArrayList<>();

		Map<Character, Integer> map2 = calculateFrequency(p);

		String sub = "";
		for (int i = 0; i < p.length(); i++) {
			sub = sub + s.charAt(i);
		}

		Map<Character, Integer> map1 = calculateFrequency(sub);

		if (map1.equals(map2)) {
			list.add(0);
		}

		int index = 1;
		for (int i = p.length(); i < s.length(); i++) {

			updateMap(s.charAt(index - 1), s.charAt(i), map1);

			if (map1.equals(map2)) {
				list.add(index);

			}
			index++;
		}

		return list;

	}

	private static void updateMap(char keyTobeRemoved, char keyToBeAdded, Map<Character, Integer> map1) {

		if (map1.get(keyTobeRemoved) == null || map1.get(keyTobeRemoved) == 1) {
			map1.remove(keyTobeRemoved);
		} else {
			map1.put(keyTobeRemoved, map1.get(keyTobeRemoved) - 1);
		}

		if (map1.containsKey(keyToBeAdded)) {
			map1.put(keyToBeAdded, map1.get(keyToBeAdded) + 1);
		} else {
			map1.put(keyToBeAdded, 1);
		}

	}

	private static Map<Character, Integer> calculateFrequency(String p) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < p.length(); i++) {
			Character c = p.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);

		}

		return map;
	}

}
