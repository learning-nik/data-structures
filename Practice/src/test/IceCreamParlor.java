package test;

import java.util.HashMap;
import java.util.Map;

public class IceCreamParlor {

	/*
	 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
*/	public static void main(String[] args) {

		//int [] cost = {2,2,4,3};
		//int [] cost = {1,4,5,3,2};
		int [] cost = {4,3,2,5,7};
		int money =8;
		whatFlavors1(cost, money);
	}

	static void whatFlavors(int[] cost, int money) {
		boolean flag = false;
		for (int i = 0; i < cost.length; i++) {
			if (cost[i] < money) {
				for (int j = i + 1; j < cost.length; j++) {
					if (cost[i] + cost[j] == money) {
						System.out.println(i + 1 + " " + (j + 1));
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
		}
	}
	
	static void whatFlavors1(int[] cost, int money) {
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < cost.length; i++) {
			if (map.containsKey(cost[i])) {
				map.put(cost[i],map.get(cost[i])+" "+(i+1));
			} else {
				map.put(cost[i],String.valueOf((i+1)));
			}
		}
		
		for (int i = 0; i < cost.length; i++) {
			int value= money-cost[i];
			if(map.containsKey(value)&& value==money/2) {
				System.out.println(map.get(value));
				break;
			}
			if(map.containsKey(value)){
				System.out.println(i + 1 + " " + (map.get(value)));
				break;
			}
		}

	}

}
