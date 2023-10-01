package com.questions.arrays;

// Sort an array of zeros and ones.
public class ArrayOfZerosAndOnes {

	// Solutions:
	// 1.  Direct sort an array --> TC --> O(n logn)
	// 2.  Count all the zeros and ones in first iteration and then append them in 2nd iteration --> TC --> O(2n) 
	// 3.  Best solution --> keep 2 pointers , left one looks for a one and right one looks for a zero and swaps 
	//  Best TC : O(N)

	public static void main(String[] args) {

		int a[] = { 0, 1, 0, 1, 0 };

	    twoPointer(a);

		//twoPointer2(a);

		printArray(a);

	}

	private static void twoPointer(int a[]) {
		int left = 0;
		int right = a.length - 1;

		while (left < right) {
			
			if (a[left] == 1 && a[right] == 0 ) {
				//swap the values
				a[left] = 0;
				a[right] = 1;
			}

			if (a[left] == 0) {
				left++;
			}

			if (a[right] == 1) {
				right--;
			}
			
		}

	}

	private static void twoPointer2(int a[]) {
		int left = 0;
		int right = a.length - 1;

		while (left < right) {

			if (a[left] == 1 && a[right] == 0) {
				//swap the values
				a[left] = 0;
				a[right] = 1;
				
			}

			else if (a[left] == 0 && a[right] == 0) {
				left++;
			}

			else {
				right--;
			}

		}

	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
