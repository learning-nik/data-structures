package com.questions.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

//DSA VIDEOS
//https://practice.geeksforgeeks.org/problems/second-largest3735/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// Similar question --> https://leetcode.com/problems/maximum-product-of-three-numbers/description/
public class SecondLargestElement {

	public static void main(String[] args) {

		int a[] = { 36, 35, 1, 10, 35, 1, 36 };

		secondLargest(a);
		thirdLargest(a);
		secondSmallest(a);
		//sortAndFind(a);
	}

	// TC : o(n)
	// Three cases are there :
	// 1. a[i] can be greater than largest 
	// 2. a[i] lies b/w largest and second
	// 3 . a[i] less than largest and second
	private static void secondLargest(int[] a) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > largest) {
				//a[i] is greater than largest 
				secondLargest = largest;
				largest = a[i];
			}

			else if (a[i] > secondLargest && a[i] != largest) {
				//a[i] lies b/w largest and second
				// (a[i] != largest) this check is necessary in case there largest num has duplicate values
				// e.g  // [5 , 4 , 5]
				secondLargest = a[i];
			}
			//a[i] less than largest and second -- no action needed.
		}

		System.out.println("secondLargest  is:" + secondLargest);
	}

	// int a[] = { 36, 35, 1, 10, 35, 1, 36 };
	private static void thirdLargest(int[] a) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		int thirdLargest = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > largest) {
				thirdLargest = secondLargest;
				secondLargest = largest;
				largest = a[i];
			}

			else if (a[i] > secondLargest && a[i] != largest) {
				thirdLargest = secondLargest;
				secondLargest = a[i];

			}

			else if (a[i] > thirdLargest && a[i] != secondLargest && a[i] != largest) {
				thirdLargest = a[i];

			}

		}
		System.out.println("Third largest is:" + thirdLargest);
	}

	private static void secondSmallest(int[] a) {

		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] < smallest) {
				secondSmallest = smallest;
				smallest = a[i];
			}

			else if (a[i] < secondSmallest && a[i] != smallest) {
				secondSmallest = a[i];
			}
		}

		System.out.println("secondSmallest  is:" + secondSmallest);

	}

	// add in TreeSet
	//O(nlogn) adding elements in treeSet
	private static void secondSmallestUsingSet(int[] arr) {

		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		int count = 1;
		for (Integer element : set) {
			if (count == 2) {
				System.out.println("secondSmallest using set is:" + element);
				break;
			}
			count++;

		}

	}

	// TC : o(n logn)
	private static void sortAndFind(int[] a) {
		Arrays.sort(a);

		int small = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] != small) {
				System.out.println("Second Smallest is :" + a[i]);
				break;
			}
		}
		int large = a[a.length - 1];
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != large) {
				System.out.println("Second Largest is :" + a[i]);
				break;
			}
		}

	}

}
