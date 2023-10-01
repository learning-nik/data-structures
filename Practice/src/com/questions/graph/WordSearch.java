package com.questions.graph;
//https://leetcode.com/problems/word-search/description/
public class WordSearch {

	public static void main(String[] args) {

		char[][] board = { { 'A', 'B', 'C', 'E' }, 
						   { 'S', 'F', 'C', 'S' }, 
						   { 'A', 'D', 'E', 'E' } };

		String word = "ABCCED";

		System.out.println(exist(board, word));

	}

	public static boolean exist(char[][] board, String word) {

		int rows = board.length;
		int col = board[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				if (dfs(board, i, j, 0, word))
					return true;

			}
		}

		return false;
	}

	private static boolean dfs(char[][] board, int row, int col, int index, String word) {

		// base cases

		// full word has been traversed
		if (index == word.length()) {
			return true;
		}

		// end of board
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
			return false;
		}

		// word did not match
		if (board[row][col] != word.charAt(index)) {
			return false;
		}

		// make it visited 
		board[row][col] ^= 256;
		

		boolean exists =
				// top 
					dfs(board, row - 1, col, index + 1, word) ||
				// bottom 
						dfs(board, row + 1, col, index + 1, word) ||
						// left
						dfs(board, row, col - 1, index + 1, word) ||
						// right
						dfs(board, row, col + 1, index + 1, word);

		// change it back
		board[row][col] ^= 256;

		return exists;

	}

}
