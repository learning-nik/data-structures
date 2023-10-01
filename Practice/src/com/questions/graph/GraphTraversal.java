package com.questions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

	public static void main(String[] args) {

		//		Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]

		List<Integer> list1 = Arrays.asList(2, 3, 1);
		List<Integer> list2 = new ArrayList<>(0);
		List<Integer> list3 = Arrays.asList(0, 4);
		List<Integer> list4 = new ArrayList<>(0);
		List<Integer> list5 = new ArrayList<>(2);

		List<List<Integer>> adj = new ArrayList<>();
		adj.add(list1);
		adj.add(list2);
		adj.add(list3);
		adj.add(list4);
		adj.add(list5);

		List<Integer> bfsList = bfsOfGraph(5, adj);

		bfsList.forEach(a -> System.out.print(a + ": "));

		System.out.println("--------------------------");

		List<Integer> dfsList = new GraphTraversal().dfsOfGraph(5, adj);

		dfsList.forEach(a -> System.out.print(a + ": "));

	}

	//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
	// Function to return Breadth First Traversal of given graph.
	public static List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {

		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[V];
		queue.add(0);

		List<Integer> answer = new ArrayList<>();

		while (!queue.isEmpty()) {

			int element = queue.poll();

			if (!visited[element]) {
				visited[element] = true;
				answer.add(element);

				for (Integer connectedElement : adj.get(element)) {
					queue.add(connectedElement);
				}
			}

		}

		return answer;
	}

	//	https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
	public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {

		List<Integer> answer = new ArrayList<>();
		boolean visited[] = new boolean[V];

		dfs(adj, answer, visited, 0);

		return answer;

	}

	//		Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]
	private void dfs(List<List<Integer>> adj, List<Integer> answer, boolean[] visited, int element) {

		/*if (!visited[element]) {
			answer.add(element);
			visited[element] = true;
		
			for (Integer current : adj.get(element)) {
				dfs(adj, answer, visited, current);
			}
		}*/

		// both are working , but this is better

		answer.add(element);
		visited[element] = true;

		for (Integer current : adj.get(element)) {
			if (!visited[current]) {
				dfs(adj, answer, visited, current);
			}
		}

	}

}
