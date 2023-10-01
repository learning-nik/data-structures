package com.questions.matrix;

public class SearchInRowAndColumnSortedMatrix {

	public static void main(String[] args) {
		
		int a[][] = {{1,5,9},{2,6,10},{3,7,11}};
		print(a);
		System.out.println(search(a,1));
	}
	
	private static String search(int[][] a, int element) {
		
		
		//int topRight = a[0][a[0].length-1];
		int i=0; 
		int j=a[0].length-1;
		
		while(i<a.length && j >=0) {
			if(element == a[i][j]) {
				return "TRUE";
			}
			else if(element > a[i][j]) {
				i++;
			}
			else {
				j--;
			}
		}
		
		return "FALSE";
	}

	private static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
}


