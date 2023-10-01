package com.questions.graph;

// https://tutorialhorizon.com/algorithms/backtracking-search-a-word-in-a-matrix/
// path will be in a matrix
public class WordSearchWithPath {

	public static void main(String[] args) {

		char[][] matrix = { 
				{ 't', 'z', 'x', 'c', 'd' }, 
				{ 'a', 'h', 'n', 'z', 'x' }, 
				{ 'h', 'w', 'o', 'i', 'o' },
				{ 'o', 'r', 'n', 'r', 'n' }, 
				{ 'a', 'b', 'r', 'i', 'n' } };

		WordMatrix w = new WordMatrix(matrix.length);
		if (w.searchWord(matrix, "abr")) {
			w.print();
		} else {
			System.out.println("NO PATH FOUND");
		}

	}

	static class WordMatrix {
		public int[][] solution;
		int path = 1;

		// initialize the solution matrix in constructor.
		public WordMatrix(int N) {
			solution = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					solution[i][j] = 0;
				}
			}
		}

		public boolean searchWord(char[][] matrix, String word) {
			int N = matrix.length;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (search(matrix, word, i, j, 0, N)) {
						return true;
					}
				}
			}
			return false;
		}

		public boolean search(char[][] matrix, String word, int row, int col, int index, int N) {

			// check if current cell not already used or character in it is not not

			if (solution[row][col] != 0 || word.charAt(index) != matrix[row][col]) {
				return false;
			}

			if (index == word.length() - 1) {
				// word is found, return true
				solution[row][col] = path++;
				return true;
			}

			// mark the current cell as 1
			solution[row][col] = path++;
			// check if cell is already used

			// go down
			if (row + 1 < N && search(matrix, word, row + 1, col, index + 1, N)) {
				return true;
			}
			// go up
			if (row - 1 >= 0 && search(matrix, word, row - 1, col, index + 1, N)) {
				return true;
			}
			// go right
			if (col + 1 < N && search(matrix, word, row, col + 1, index + 1, N)) {
				return true;
			}
			// go left
			if (col - 1 >= 0 && search(matrix, word, row, col - 1, index + 1, N)) {
				return true;
			}

			// if none of the option works out, BACKTRACK and return false
			solution[row][col] = 0;
			path--;
			return false;
		}

		public void print() {
			for (int i = 0; i < solution.length; i++) {
				for (int j = 0; j < solution.length; j++) {
					System.out.print(" " + solution[i][j]);
				}
				System.out.println();
			}
		}

	}
}
