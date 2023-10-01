package com.important.problems;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/description/
public class CombinationSum3 {
	public static void main(String[] args) {

		int k = 3;
		int n = 9;
		new CombinationSum3().combinationSum3(k, n);
	}

	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> mainList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		//backtrack(mainList , list , k , n ,n ,1);

		int data[] = new int[9];
		for (int i = 0; i <= 8; i++) {
			data[i] = i + 1;
		}

		backtrack(mainList, list, k, data, n, 0);

		System.out.println(mainList);

		return mainList;
	}

	private void backtrack(List<List<Integer>> mainList, List<Integer> list, int k, int[] data, int sumLeft,
			int index) {

		if (sumLeft == 0 && list.size() == k) {
			mainList.add(new ArrayList<>(list));
			return;
		}

		if (sumLeft < 0 || list.size() >= k) {
			return;
		}

		for (int i = index; i < data.length; i++) {
			list.add(data[i]);
			backtrack(mainList, list, k, data, sumLeft - data[i], i + 1);
			list.remove(list.size() - 1);

		}

	}

	//  better , not using any extra array
	private void backtrack(List<List<Integer>> mainList, List<Integer> list, int k, int n, int sumLeft, int index) {

		if (sumLeft == 0 && list.size() == k) {
			mainList.add(new ArrayList<>(list));
			return;
		}

		if (sumLeft < 0 || list.size() >= k) {
			return;
		}

		for (int i = index; i <= 9; i++) {
			list.add(i);
			backtrack(mainList, list, k, n, sumLeft - i, i + 1);
			list.remove(list.size() - 1);

		}

	}

	// working but needs more no of method args
	/*private void backtrack(List<List<Integer>> mainList, List<Integer> list, int k, int[] data, int currentSum,
			int index, int n) {
	
		if (currentSum == n && list.size() == k) {
			mainList.add(new ArrayList<>(list));
			return;
		}
	
		if (currentSum >= n || list.size() >= k) {
			//index = index + 1;
			return;
		}
	
		for (int i = index; i < data.length; i++) {
			list.add(data[i]);
			backtrack(mainList, list, k, data, data[i] + currentSum, i + 1, n);
			list.remove(list.size() - 1);
	
		}
	
	}*/

}
