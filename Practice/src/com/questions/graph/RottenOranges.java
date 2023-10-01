package com.questions.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/description/
public class RottenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*	{ 2, 1, 1 }, 
			{ 1, 1, 0 }, 
			{ 0, 1, 1 }*/

		/*{ 2, 2 }, 
		{ 1, 1 }, 
		{ 0, 0 }, 
		{ 2, 0 }*/

		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

		//	int[][] grid = { { 2, 2 }, { 1, 1 }, { 0, 0 }, { 2, 0 } };
		System.out.println(orangesRotting(grid));

	}

	public static int orangesRotting(int[][] grid) {

		int count = 0;
		int good = 0;
		Queue<Orange> queue = new LinkedList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// rotten orange
				if (grid[i][j] == 2) {
					queue.add(new Orange(i, j, 0));
				} else if (grid[i][j] == 1) {
					good++;
				}

			}
		}

		// No rotten oranges
		if (queue.isEmpty()) {
			return -1;
		}

		// No good oranges
		if (good == 0) {
			return 0;
		}

		/*	{ 2, 1, 1 }, 
		{ 1, 1, 0 }, 
		{ 0, 1, 1 }*/
		while (!queue.isEmpty()) {

			Orange orange = queue.poll();
			int row = orange.row;
			int col = orange.column;
			count = orange.time;

			// make it rotten
			//grid[row][col] = 2;

			// top
			if (row >= 1 && grid[row - 1][col] == 1) {
				grid[row - 1][col] = 2;
				queue.add(new Orange(row - 1, col, orange.time + 1));
			}

			// bottom
			if (row < grid.length - 1 && grid[row + 1][col] == 1) {
				grid[row + 1][col] = 2;
				queue.add(new Orange(row + 1, col, orange.time + 1));
			}

			// right
			if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
				grid[row][col + 1] = 2;
				queue.add(new Orange(row, col + 1, orange.time + 1));
			}

			// left
			if (col >= 1 && grid[row][col - 1] == 1) {
				grid[row][col - 1] = 2;
				queue.add(new Orange(row, col - 1, orange.time + 1));
			}

			//			grid[row][col] = 2;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}

		return count;

	}

	static class Orange {
		int row;
		int column;
		int time;

		public Orange(int row, int column, int time) {
			this.row = row;
			this.column = column;
			this.time = time;
		}

	}

}
