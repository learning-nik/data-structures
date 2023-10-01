package com.questions.graph;

import java.util.ArrayList;
import java.util.List;

// path will be in a list
public class WordSearchWithPath2 {

	public static void main(String[] args) {

		char[][] matrix = 
			{ { 't', 'z', 'x', 'c', 'd' }, 
			  { 'a', 'h', 'n', 'z', 'x' }, 
			  { 'h', 'w', 'o', 'i', 'o' },
			  { 'o', 'r', 'n', 'r', 'n' }, 
			  { 'a', 'b', 'r', 'i', 'n' }

		};

		String word = "hwo";

		findWordWithPath(matrix, word);

	}

	private static void findWordWithPath(char[][] matrix, String word) {

		int[][] pathMatrix = new int[matrix.length][matrix[0].length];
		List<String> list = new ArrayList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (findPath(matrix, word, pathMatrix, i, j, 0, 1, list)) {
					System.out.println("Path found");
					printPathMatrix(pathMatrix);
					System.out.println(list);
					return;
				}
			}
		}

		System.out.println("Could not find path");

	}

	private static boolean findPath(char[][] matrix, String word, int[][] pathMatrix, int row, int col, int index,
			int count, List<String> list) {

		if (index == word.length()) {
			return true;
		}

		if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length) {
			return false;
		}

		if (word.charAt(index) != matrix[row][col]) {
			return false;
		}

		// word is found , make it visited
		matrix[row][col] ^= 256;
		list.add(row + ":" + col);
		pathMatrix[row][col] = count++;

		// top 
		if (findPath(matrix, word, pathMatrix, row - 1, col, index + 1, count, list)) {
			return true;
		}

		if (findPath(matrix, word, pathMatrix, row + 1, col, index + 1, count, list)) {
			return true;
		}

		if (findPath(matrix, word, pathMatrix, row, col - 1, index + 1, count, list)) {
			return true;
		}

		if (findPath(matrix, word, pathMatrix, row, col + 1, index + 1, count, list)) {
			return true;
		}

		matrix[row][col] ^= 256;
		pathMatrix[row][col] = 0;
		count--;
		list.remove(list.size() - 1);

		return false;
	}

	private static void printPathMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				System.out.print(matrix[i][j] + ",");

			}
			System.out.println();
		}
	}
}
