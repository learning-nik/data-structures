package test;

import java.util.HashMap;
import java.util.Map;

public class MakeAnagram {

	public static void main(String[] args) {
		
		System.out.println('A'+0);
		
		System.out.println(makeAnagram("abcd", "abcde"));

	}

	static int makeAnagram(String a, String b) {

		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		for (int i = 0; i < a.length(); i++) {
			 map1.put(a.charAt(i),map1.getOrDefault(a.charAt(i),0)+1);
		}

		for (int i = 0; i < b.length(); i++) {
				map2.put(b.charAt(i), map2.getOrDefault(b.charAt(i),0) + 1);
			}
		int count = 0;
		for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
			if (map2.get(entry.getKey()) == null) {
				count += entry.getValue();
			} else {
				if (entry.getValue() > map2.get(entry.getKey())) {
					count += entry.getValue() - map2.get(entry.getKey());
				}
			}
		}

		for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
			if (map1.get(entry.getKey()) == null) {
				count += entry.getValue();
			} else {
				if (entry.getValue() > map1.get(entry.getKey())) {
					count += entry.getValue() - map1.get(entry.getKey());
				}
			}
		}
		return count;

	}
}
