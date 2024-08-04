package com.questions.heap;

import java.util.PriorityQueue;

public class ClosestPointToOrigin {

	public static void main(String[] args) {

		int[][] points = { { 1, 3 }, { -2, 2 } };

		int k = 1;
		int answer[][] = new ClosestPointToOrigin().kClosest(points, k);

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(answer[i][j]);
			}
		}

	}

	public int[][] kClosest(int[][] points, int k) {

		PriorityQueue<Wrapper> queue = new PriorityQueue<>();

		int ans[][] = new int[k][2];

		// add element in queue , with index and squareRoot
		for (int i = 0; i < points.length; i++) {
			Double value = 0d;
			for (int j = 0; j < 2; j++) {
				value = value + points[i][j] * points[i][j];
			}
			value = Math.sqrt(value);
			queue.add(new Wrapper(i, value));

		}

		for (int i = 0; i < k; i++) {
			int index = queue.poll().index;
			ans[i] = points[index];
		}

		return ans;

	}

	static class Wrapper implements Comparable<Wrapper> {

		int index;
		Double value;

		Wrapper(int index, Double value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Wrapper o) {
			return this.value.compareTo(o.value);
		}

		@Override
		public String toString() {
			return "Wrapper [index=" + index + ", value=" + value + "]";
		}

	}

	public int[][] kClosestWithoutWrapper(int[][] points, int k) {

		PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> {
			return (a1[0] * a1[0] + a1[1] * a1[1]) - (a2[0] * a2[0] + a2[1] * a2[1]);
		});

		int[][] ans = new int[k][2];

		for (int i = 0; i < points.length; i++) {
			queue.add(points[i]);
		}

		for (int i = 0; i < k; i++) {
			ans[i] = queue.poll();
		}

		return ans;

	}

}
