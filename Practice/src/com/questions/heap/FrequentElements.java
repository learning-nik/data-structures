package com.questions.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/
public class FrequentElements {

	public static void main(String[] args) {

		int k = 2;

		//int nums[] = { 1, 1, 1, 2, 2, 3 };

		int nums[] = { 1, 2 };

		new FrequentElements().topKFrequent(nums, k);

	}

	// Space : O(n)
	// Time : O(n)
	public int[] topKFrequent(int[] nums, int k) {

		int[] answer = new int[k];

		// calculate frequency
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		// array of integer list
		List<Integer> test[] = new List[nums.length];

		// put each element in the array according to the frequency.
		// if frequency is 1 , it will it index 0 and so on.
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			int index = entry.getValue() - 1;
			int key = entry.getKey();

			if (test[index] != null) {
				test[index].add(key);

			} else {
				test[index] = new ArrayList<>();
				test[index].add(key);
			}
		}

		// put the first k element from the right into the answer
		int j = 0;
		for (int i = test.length - 1; i >= 0; i--) {
			if (test[i] != null) {
				List<Integer> sublist = test[i];
				for (int l = 0; l < sublist.size(); l++) {
					answer[j++] = sublist.get(l);
					k--;
				}

			}

			if (k <= 0) {
				break;
			}
		}
		return answer;

	}

	// Space : O(n)
	// Time : NlogN
	public static List<String> topKFrequentWithMaxHeap(String[] words, int k) {
		List<String> answer = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}

		// Sort by desc order of freq and asc order of keys
		// When freq is equal sort by key

		PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((e1, e2) -> {
			//return e1.getValue().compareTo(e1.getValue());
			if (e1.getValue().equals(e2.getValue())) {
				return e1.getKey().compareTo(e2.getKey());
			} else {
				return -e1.getValue().compareTo(e2.getValue());
			}
		});

		queue.addAll(map.entrySet());

		for (int i = 0; i < k; i++) {
			answer.add(queue.poll().getKey());
		}

		return answer;
	}

	// Space : O(n)
	// Time : Nlogk
	public static List<String> topKFrequentWithMinHeap(String[] words, int k) {

		List<String> answer = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}

		// Sort by asc order of freq and desc order of keys.
		PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((e1, e2) -> {

			if (e1.getValue().equals(e2.getValue())) {
				return -e1.getKey().compareTo(e2.getKey());
			} else {
				return e1.getValue().compareTo(e2.getValue());
			}
		});

		// Storing only k elements in the heap
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			queue.add(entry);

			if (queue.size() > k) {
				queue.poll();
			}
		}

		//System.out.println(queue);

		while (!queue.isEmpty()) {
			answer.add(0, queue.poll().getKey());
		}

		return answer;
	}

}
