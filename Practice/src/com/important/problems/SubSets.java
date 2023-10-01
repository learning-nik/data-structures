package com.important.problems;

import java.util.ArrayList;
import java.util.List;

// Subsequences of a string or subsets of a set
//https://leetcode.com/problems/subsets/
// Total no of subsets of a set are : 2^n
// "123"  --> 2^3 --> 8 --> 1 , 2 , 3 , 12 , 13 , 23, 123  , ""
public class SubSets {

	public static void main(String[] args) {

		String a = "123";
		List<String> answer = new ArrayList<>();
		allSubSequences(answer, a, 0, "");
		System.out.println(answer);

		int input[] = { 1, 2, 3 };
		List<List<Integer>> answer1 = new ArrayList<>();
		allSubsets(answer1, input, 0, new ArrayList<>());
		System.out.println(answer1);

		int input2[] = { 1, 2, 3 };
		List<List<Integer>> answer2 = new ArrayList<>();
		backtrack(input2, new ArrayList<>(), answer2, 0);
		System.out.println(answer2);

	}

	// Using Include / Exclude pattern of recurrsion
	// This is like a top to bottom approach
	private static void allSubSequences(List<String> answer, String input, int index, String current) {

		if (index == input.length()) {
			answer.add(current);
			return;
		}

		// include the element
		allSubSequences(answer, input, index + 1, current + input.charAt(index));

		// exclude the element
		allSubSequences(answer, input, index + 1, current);

	}

	private static void allSubsets(List<List<Integer>> answer, int[] input, int index, List<Integer> current) {

		if (index == input.length) {
			answer.add(current);
			return;
		}

		// include the element
		List<Integer> list = new ArrayList<>(current);
		list.add(input[index]);
		allSubsets(answer, input, index + 1, list);

		// exclude the element
		allSubsets(answer, input, index + 1, current);

	}

	// Using BackTracking
	// This is like a  bottom to top approach
	private static void backtrack(int[] nums, List<Integer> list, List<List<Integer>> finalList, int index) {

		finalList.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			backtrack(nums, list, finalList, i + 1);
			list.remove(list.size() - 1);
		}

	}

}
