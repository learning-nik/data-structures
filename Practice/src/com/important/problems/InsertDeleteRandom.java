package com.important.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/description/
public class InsertDeleteRandom {

	List<Integer> list = null;
	Map<Integer, Integer> map = null;
	Random random = new Random();

	public InsertDeleteRandom() {
		list = new ArrayList<>();
		map = new HashMap<>();
	}

	public static void main(String[] args) {

		// ["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
		// [[],[0],[1],[0],[2],[1],[]]

		InsertDeleteRandom insertDeleteRandom = new InsertDeleteRandom();
		insertDeleteRandom.insert(0); // 0
		insertDeleteRandom.insert(1); // 0 , 1

		insertDeleteRandom.remove(0); // 1

		insertDeleteRandom.insert(2); // 1 , 2

		insertDeleteRandom.remove(1); // 2

		System.out.println(insertDeleteRandom.getRandom());

	}

	public boolean insert(int val) {

		if (map.containsKey(val)) {
			// already present no need to insert
			return false;
		}
		// insert into map and list
		list.add(val);
		// store the index of added element as value of map
		// as element is always added to the end of list.
		map.put(val, list.size() - 1);
		return true;

	}

	public boolean remove(int val) {

		if (map.containsKey(val)) {

			int currentIndex = map.get(val);
			int lastIndex = list.size() - 1;

			Collections.swap(list, lastIndex, currentIndex);

			// update the key and index in map after swap
			int exchangedValue = list.get(currentIndex);
			map.put(exchangedValue, currentIndex);

			// remove from list and map
			list.remove(lastIndex);
			map.remove(val);

			return true;

		}
		// not present , no action needed.
		return false;

	}

	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}

}
