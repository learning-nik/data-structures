package com.questions.graph;

//https://leetcode.com/problems/number-of-islands/
public class NoOfIslands {

	/*['1','1','0','0','0'],
	  ['1','1','0','0','0'],
	  ['0','0','1','0','0'],
	  ['0','0','0','1','1']*/

	public static void main(String[] args) {

		char[][] grid =

				{ { '1', '1', '0', '0', '0' }, 
				  { '1', '1', '0', '0', '0' }, 
				  { '0', '0', '1', '0', '0' },
				  { '0', '0', '0', '1', '1' }, };

		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {

		int count = 0;

		// traverse through grid and check for 1
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == '1') {
					count++;
					dfs(i, j, grid);
				}

			}
		}

		return count;

	}

	// traverse to the top , right , down , right
	private static void dfs(int row, int col, char[][] grid) {

		// Base case 
		// when row and column go out of bound
		// or when land is not found
		if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] != '1') {
			return;
		}

		// make it visited
		grid[row][col] = '2';

		// top
		dfs(row - 1, col, grid);

		// right
		dfs(row, col + 1, grid);

		// down
		dfs(row + 1, col, grid);

		// left
		dfs(row, col - 1, grid);
	}

}
