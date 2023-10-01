package com.questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/merge-intervals/submissions/
public class MergeOverlappingSubIntervals {

	public static void main(String[] args) {

		//new MergeOverlappingSubIntervals().mergeIntervals();

		//int intervals[][] = { { 2, 6 }, { 1, 3 }, { 8, 10 }, { 15, 18 } };

		//printArray(intervals);

		//new MergeOverlappingSubIntervals().mergeIntervalsWithoutStack();

		//printArray(merge(intervals));

		//new MergeOverlappingSubIntervals().insertIntervals();

		/*		int intervals[][] = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
				int newInterval[] = { 4, 8 };
		
				new MergeOverlappingSubIntervals().insert(intervals, newInterval);*/

		//int intervals[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		int intervals[][] = { { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6 } };
		System.out.println(eraseOverlapIntervals(intervals));

	}

	// Using Stack
	private void mergeIntervals() {

		List<Interval> list = new ArrayList<>();
		list.add(new Interval(6, 8));
		list.add(new Interval(1, 9));
		list.add(new Interval(2, 4));
		list.add(new Interval(4, 7));

		Collections.sort(list);

		System.out.println(list);

		Stack<Interval> stack = new Stack<>();

		for (Interval element : list) {
			if (stack.isEmpty()) {
				stack.push(element);
			} else {
				if (element.getStartTime() < stack.peek().getEndTime()) {
					Interval lastElement = stack.pop();
					stack.push(new Interval(lastElement.getStartTime(),
							Math.max(element.getEndTime(), lastElement.getEndTime())));
				} else {
					stack.push(element);
				}
			}
		}

		System.out.println(new ArrayList<>(stack));
	}

	public void mergeIntervalsWithoutStack() {

		List<Interval> list = new ArrayList<>();
		list.add(new Interval(6, 8));
		list.add(new Interval(1, 3));
		list.add(new Interval(5, 7));
		list.add(new Interval(4, 7));

		Collections.sort(list);

		System.out.println(list);

		List<Interval> finalList = new ArrayList<>();

		Interval interval = list.get(0);

		for (Interval element : list) {

			if (element.getStartTime() > interval.getEndTime()) {
				// no overrlap , then directly add the interval to list
				finalList.add(new Interval(interval.getStartTime(), interval.getEndTime()));
				interval = element;
			} else {
				// update the interval
				interval.setEndTime(Math.max(interval.getEndTime(), element.getEndTime()));
			}

		}

		finalList.add(interval);

		System.out.println(finalList);
	}

	//int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

	// 1,3 
	// 2,6
	// 5,10

	public static int[][] merge(int[][] intervals) {

		// sort this array.
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> list = new ArrayList<>();

		int[] current = intervals[0];

		for (int i = 0; i < intervals.length; i++) {

			if (intervals[i][0] > current[1]) {
				//no overrlap , then directly add the interval to list.

				/*int c1[] = new int[] {current[0],current[1]};
				list.add(c1);*/

				list.add(current);

				current = intervals[i];

			} else {
				// Overlap is there , update the current pointer.
				int maxInt = Math.max(intervals[i][1], current[1]);

				current[1] = maxInt;
			}

		}

		list.add(current);

		int[][] finalArray = new int[list.size()][];

		return list.toArray(finalArray);

	}

	private static void printArray(int[][] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				System.out.print(a[i][j] + ":");
			}

			System.out.print(",");
		}

	}

	public void insertIntervals() {

		List<Interval> finalList = new ArrayList<>();

		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1, 2));
		list.add(new Interval(4, 9));
		list.add(new Interval(12, 16));

		System.out.println(list);

		Interval toBeMerged = new Interval(13, 21);

		System.out.println("ToBeMerged: " + toBeMerged);

		for (Interval current : list) {

			if (checkIfOverlaps(current, toBeMerged))

			{
				// Overlap is there
				int min = Math.min(current.getStartTime(), toBeMerged.getStartTime());
				int max = Math.max(current.getEndTime(), toBeMerged.getEndTime());

				toBeMerged.setStartTime(min);
				toBeMerged.setEndTime(max);

			} else {
				// no overlap
				if (current.getStartTime() < toBeMerged.getStartTime()) {
					finalList.add(current);

				} else {
					finalList.add(new Interval(toBeMerged.getStartTime(), toBeMerged.getEndTime()));
					toBeMerged = current;
				}

			}

		}

		finalList.add(toBeMerged);

		System.out.println(finalList);
	}

	//intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]

	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {

			if (!checkIfOverlapsArray(intervals[i], newInterval)) {
				// no overlap

				if (intervals[i][0] < newInterval[0]) {
					list.add(intervals[i]);
				} else {

					list.add(newInterval);
					newInterval = intervals[i];
				}

			} else {

				// update the new interval.
				int left = Math.min(intervals[i][0], newInterval[0]);
				int right = Math.max(intervals[i][1], newInterval[1]);

				newInterval[0] = left;
				newInterval[1] = right;

			}

		}

		list.add(newInterval);

		int[][] finalArray = new int[list.size()][];

		int[][] answer = list.toArray(finalArray);

		// printArray(answer);

		return answer;

		//return list.toArray();
	}

	private boolean checkIfOverlapsArray(int[] current, int[] newInterval) {

		// First check which interval starts first
		// Then , the end point of the starting interval should be more 
		// then  start point of the ending interval, then its a overlap  

		if (current[0] < newInterval[0]) {
			return (current[1] >= newInterval[0]);

		} else {
			return (newInterval[1] >= current[0]);
		}

	}

	private boolean checkIfOverlaps(Interval current, Interval toBeMerged) {

		Interval startsFirst = current;
		Interval startsLate = toBeMerged;

		if (current.getStartTime() > toBeMerged.getStartTime()) {
			startsFirst = toBeMerged;
			startsLate = current;

		}

		if (startsLate.getStartTime() < startsFirst.getEndTime()) {
			return true;
		}

		return false;
	}

	class Interval implements Comparable<Interval> {

		private Integer startTime;

		private Integer endTime;

		Interval(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public Integer getStartTime() {
			return startTime;
		}

		public Integer getEndTime() {
			return endTime;
		}

		public void setStartTime(Integer startTime) {
			this.startTime = startTime;
		}

		public void setEndTime(Integer endTime) {
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Interval o) {
			// TODO Auto-generated method stub
			return this.startTime.compareTo(o.startTime);
		}

		@Override
		public String toString() {
			return "Interval [startTime=" + startTime + ", endTime=" + endTime + "]";
		}

	}

	//https://leetcode.com/problems/non-overlapping-intervals/description/
	// 1:2:,1:3:,2:3:,3:4:,
	//{ { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 } , {4,6} }

	public static int eraseOverlapIntervals(int[][] intervals) {
		// Sort by start time
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int count = 0;
		int[] last = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < last[1]) {
				count++;
				if (intervals[i][1] < last[1]) {
					last = intervals[i];
				}
			} else {
				last = intervals[i];
			}
		}

		return count;

	}
}