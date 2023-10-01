package com.questions.arrays;

/*https://practice.geeksforgeeks.org/batch/dsa-4/
 * Video- 
*/public class RemoveDuplicates {

	public static void main(String[] args) {

		int a[] = { 1,1, 2, 2, 3, 4, 5, 6, 7, 7, 7, 7 };
		int j = 1;
		int i = 0;
		while (i < a.length && j < a.length) {
			if (a[i] == a[j]) {
				j++;
			} else {
				a[i + 1] = a[j];
				i++;
				j++;
			}
		}
		for (int k = 0; k < 7; k++) {
			System.out.print(a[k] + ", ");
		}
	}
}
