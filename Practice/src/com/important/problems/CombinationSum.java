package com.important.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/?orderBy=most_votes
//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSum {

	public static void main(String[] args) {

		List<List<Integer>> mainList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		/*int[] cand = { 2, 3, 6, 7 };
		int target = 7;
		
		solve(cand, target, 0, mainList, list);*/

		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;

		Arrays.sort(candidates);
		combinationSum2(candidates, target, 0, mainList, list);

		mainList.forEach(a -> System.out.println(a));

	}

	// CombinationSum1
	// Each element can be picked more than once.
	// Given input of cand[] is  distinct. 
	private static void solve(int[] cand, int target, int index, List<List<Integer>> mainList, List<Integer> list) {

		if (target < 0) {
			return;
		}

		if (target == 0) {
			mainList.add(new ArrayList<>(list));
			return;
		}

		for (int i = index; i < cand.length; i++) {

			list.add(cand[i]);
			solve(cand, target - cand[i], i, mainList, list);
			list.remove(list.size() - 1);

		}

	}

	// CombinationSum2
	// Only pick each element once
	// Given input of cand[] is not distinct. 
	public static void combinationSum2(int[] cand, int target, int start, List<List<Integer>> mainList,
			List<Integer> list) {

		if (target < 0) {
			return;
		}

		if (target == 0) {
			mainList.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i < cand.length; i++) {
			// check for duplicates
			if (i > start && cand[i] == cand[i - 1])
				continue;
			list.add(cand[i]);
			// increment i+1 to avoid the same element
			combinationSum2(cand, target - cand[i], i + 1, mainList, list);
			list.remove(list.size() - 1);

		}

	}
}