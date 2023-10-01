package com.questions.arrays;

//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBanana {

	public static void main(String[] args) {
		/*int[] piles = { 3, 6, 7, 11 };
		int h = 8;*/

		/*int[] piles = { 30, 11, 23, 4, 20 };
		int h = 5;*/

		/*int[] piles = { 30, 11, 23, 4, 20 };
		int h = 6;*/

		int[] piles = { 805306368, 805306368, 805306368 };
		int h = 1000000000;

		System.out.println(new KokoEatingBanana().minEatingSpeed(piles, h));

		//System.out.println(findTimeTaken(piles, 22));

	}

	public int minEatingSpeed(int[] piles, int h) {

		// find max 
		int high = 0;
		for (int i = 0; i < piles.length; i++) {
			high = Math.max(high, piles[i]);
		}

		int low = 1;

		while (low <= high) {

			int mid = low + (high - low) / 2;

			int timeTaken = findTimeTaken(piles, mid);

			if (timeTaken <= h) {
				high = mid - 1;

			} else {
				low = mid + 1;
			}

		}

		return low;

	}

	private static int findTimeTaken(int[] piles, int speed) {

		int timeTaken = 0;
		for (int i = 0; i < piles.length; i++) {

			int value = piles[i] / speed;
			int rem = piles[i] % speed;
			if (rem != 0) {
				value++;
			}
			timeTaken = timeTaken + value;
		}

		return timeTaken;

	}

}
