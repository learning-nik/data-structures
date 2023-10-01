package com.questions.graph;

//https://leetcode.com/problems/flood-fill/description/
public class FloodFill {

	public static void main(String[] args) {

		/*int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int color = 2;*/

		int[][] image = { { 0, 0, 0 }, { 0, 0, 0 } };
		int sr = 0;
		int sc = 0;
		int color = 0;

		floodFill(image, sr, sc, color);

		printImage(image);

	}

	// DFS
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

		int oldColor = image[sr][sc];

		image[sr][sc] = color;

		if (oldColor != color) {

			// top
			if (sr >= 1 && image[sr - 1][sc] == oldColor) {
				floodFill(image, sr - 1, sc, color);
			}

			// right
			if (sc < image[0].length - 1 && image[sr][sc + 1] == oldColor) {
				floodFill(image, sr, sc + 1, color);
			}

			// bottom 
			if (sr < image.length - 1 && image[sr + 1][sc] == oldColor) {
				floodFill(image, sr + 1, sc, color);
			}

			// left
			if (sc >= 1 && image[sr][sc - 1] == oldColor) {
				floodFill(image, sr, sc - 1, color);
			}
		}

		return image;

	}

	private static void printImage(int[][] image) {

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j] + ", ");
			}
			System.out.println();
		}

	}

}
