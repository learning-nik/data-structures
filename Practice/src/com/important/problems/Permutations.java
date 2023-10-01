package com.important.problems;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=sPAT_DbvDj0&t=2s
// total permutations are : n!
// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Recursion/video/MjMzNA%3D%3D
public class Permutations {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3 };

		new Permutations().permute(a);

	}

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> mainList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		solve(mainList, list, nums);

		System.out.println("Size of mainList is:" + mainList.size());

		mainList.forEach(element -> System.out.println(element));

		List<List<Integer>> mainList2 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		solve(mainList2, nums, 0);

		System.out.println("Size of mainList is:" + mainList2.size());

		mainList2.forEach(element -> System.out.println(element));

		return mainList;

	}

	// Using Backtracking
	private void solve(List<List<Integer>> mainList, List<Integer> list, int[] nums) {

		if (list.size() == nums.length) {
			mainList.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!list.contains(nums[i])) {

				list.add(nums[i]);
				solve(mainList, list, nums);
				list.remove(list.size() - 1);
			}
		}

	}

	// Using Backtracking
	// swap approach
	//https://www.youtube.com/watch?v=va3NEycUxsg&t=515s
	private void solve(List<List<Integer>> mainList, int[] nums, int current) {

		// Base case	
		if (current == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			mainList.add(list);
			return;
		}

		for (int i = current; i < nums.length; i++) {
			swap(nums, i, current);
			solve(mainList, nums, current + 1);
			swap(nums, current, i);
		}

	}

	private void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

}
