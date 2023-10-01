package com.questions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Graph/video/MTM0OQ%3D%3D
//Detect Cycle in Undirected Graph
// Graph without any particular direction , can move to a->b and b->a
public class DetectCycle {

	public static void main(String[] args) {

		List<Integer> list0 = Arrays.asList(1);
		List<Integer> list1 = Arrays.asList(0, 2, 3);
		List<Integer> list2 = Arrays.asList(1, 3);
		List<Integer> list3 = Arrays.asList(1, 2);
		
		/*List<Integer> list0 = Arrays.asList(1);
		List<Integer> list1 = Arrays.asList(2);
		List<Integer> list2 = Arrays.asList(3);
		List<Integer> list3 = new ArrayList<>();*/

		List<List<Integer>> adj = new ArrayList<>();
		adj.add(list0);
		adj.add(list1);
		adj.add(list2);
		adj.add(list3);

		System.out.println(containsCycle(adj));

	}

	private static boolean containsCycle(List<List<Integer>> adj) {

		boolean[] visited = new boolean[adj.size()];

		return dfs(adj, -1, 0, visited);

	}

	// Cycle is a there in a graph if the child is already visited but the child != parent
	private static boolean dfs(List<List<Integer>> adj, int parent, int current, boolean[] visited) {

		visited[current] = true;

		for (Integer child : adj.get(current)) {
			if (visited[child]) {
				if (child != parent) {
					return true;
				}
			} else {

				return dfs(adj, current, child, visited);
			}
		}

		return false;
	}

}
