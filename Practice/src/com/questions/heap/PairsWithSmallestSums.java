package com.questions.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/?envType=study-plan-v2&envId=top-interview-150
public class PairsWithSmallestSums {

	public static void main(String[] args) {

		/*
		 * int[] nums1 = { 1, 7, 11 }; int[] nums2 = { 2, 4, 6 }; int k = 3;
		 */

		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3 };
		int k = 3;

		// add k into min heap
		// [1,2 ,0 ] , [7,2 , 0] , [11,2 , 0]
		// start popping out
		// ans[1,2] add [1,4 , 1] into heap --> [1,4 , 1] , [7,2 , 0] , [11,2 , 0]
		// ans[1,2] , [1,4 ] --> heap --> [1,6,2] , [7,2 , 0] , [11,2 , 0]

		List<List<Integer>> answer = new PairsWithSmallestSums().kSmallestPairs(nums1, nums2, k);

		answer.forEach(a -> System.out.println(a));

	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		List<List<Integer>> answer = new ArrayList<>();
		Queue<Pair> queue = new PriorityQueue<>();

		// add k elements
		for (int i = 0; i < k; i++) {
			if (i < nums1.length) {
				Pair pair = new Pair(nums1[i], nums2[0], 0);
				queue.add(pair);
			}
		}

		while (k > 0 && !queue.isEmpty()) {
			// System.out.println(k);
			Pair pair = queue.poll();
			List<Integer> element = Arrays.asList(pair.num1, pair.num2);
			k--;
			answer.add(element);

			if (pair.index < nums2.length - 1) {
				// index should not exceed length of second array
				Pair newIndexPair = new Pair(pair.num1, nums2[pair.index + 1], pair.index + 1);
				queue.add(newIndexPair);

			}
		}

		return answer;

	}

	static class Pair implements Comparable<Pair> {
		Integer num1;
		Integer num2;
		int index;

		public Pair(Integer num1, Integer num2, int index) {
			this.num1 = num1;
			this.num2 = num2;
			this.index = index;
		}

		@Override
		public int compareTo(Pair o) {
			Integer sum2 = o.num1 + o.num2;
			Integer sum1 = this.num1 + this.num2;
			return sum1.compareTo(sum2);
		}
	}

}
