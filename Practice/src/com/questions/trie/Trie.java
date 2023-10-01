package com.questions.trie;

// https://ide.geeksforgeeks.org/frheCz6k7a
public class Trie {

	static TrieNode root;

	static class TrieNode {

		TrieNode[] children;
		boolean isLast = false;

		public TrieNode() {
			children = new TrieNode[26];
		}

	}

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {

		TrieNode pointer = root;

		for (int i = 0; i < word.length(); i++) {

			int index = word.charAt(i) - 'a';

			if (pointer.children[index] == null) {
				pointer.children[index] = new TrieNode();
			}
			pointer = pointer.children[index];

		}

		pointer.isLast = true;
	}

	public boolean search(String word) {
		TrieNode pointer = root;

		for (int i = 0; i < word.length(); i++) {

			int index = word.charAt(i) - 'a';
			if (pointer.children[index] != null) {
				pointer = pointer.children[index];

			} else {
				return false;
			}
		}

		return pointer != null && pointer.isLast;

	}

	public boolean startsWith(String word) {

		TrieNode pointer = root;

		for (int i = 0; i < word.length(); i++) {

			int index = word.charAt(i) - 'a';
			if (pointer.children[index] != null) {
				pointer = pointer.children[index];

			} else {
				return false;
			}
		}

		return pointer != null;
	}

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.insert("nik");
		trie.insert("nikhil");
		System.out.println(trie.search("nikhil"));
		System.out.println(trie.startsWith("pa"));

	}
}
