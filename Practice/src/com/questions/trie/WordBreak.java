package com.questions.trie;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {

		/*List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		String s = "catsandog";*/
		
		List<String> wordDict = Arrays.asList("aaaa","aaa");
		String s = "aaaaaaa";
		System.out.println(new WordBreak().wordBreak(s, wordDict));

	}

	public boolean wordBreak(String s, List<String> wordDict) {

		// String s ="nikhilpandita" , "nikhil,pandita"

		Trie trie = new Trie();

		wordDict.forEach(element -> trie.insert(element));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {

			sb.append(s.charAt(i));

			if (trie.search(sb.toString())) {
				sb = new StringBuilder();

			}

		}
		return (sb.length() == 0);
	}
}
