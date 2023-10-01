package com.questions.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/
*/
public class MaxMeetingsInOneRoom {

	public static void main(String[] args) {

		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 6, 7, 9, 9 };
		/*int start[] = { 75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924 };
		int end[] = { 112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };*/

		System.out.println(maxMeetings(start, end, start.length));
	}

	//	[Meeting [start=1, end=2], Meeting [start=3, end=4],
	//  Meeting [start=0, end=6], Meeting [start=5, end=7], Meeting [start=8, end=9], Meeting [start=5, end=9]]

	// sort by end time
	public static int maxMeetings(int start[], int end[], int n) {
		int maxMeeting = 1;
		int current = 1;
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < start.length; i++) {
			list.add(new Pair(start[i], end[i]));
		}

		Collections.sort(list, (a, b) -> a.getEnd().compareTo(b.getEnd()));

		int i = 0; // this points to the last
		int j = 1; // this points to the current

		while (j < list.size() && i < list.size()) {
			if (list.get(j).getStart() > list.get(i).getEnd()) {
				// last meeting has finished
				current++;
				i = j;
				j++;

			} else {
				j++;
			}

			maxMeeting = Math.max(maxMeeting, current);

		}

		return maxMeeting;
	}

	// (1,2 --> 3,4. --> (0,6) --> (5,7) --> (8,9) --> (5,9) )
	public static int maxMeetings2(int start[], int end[], int n) {

		List<Pair> meetings = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			meetings.add(new Pair(start[i], end[i]));
		}
		Collections.sort(meetings, (a, b) -> a.getEnd().compareTo(b.getEnd()));

		int last = 0;
		int maxMeetings = 1;
		int answer = Integer.MIN_VALUE;
		for (int i = 1; i < meetings.size(); i++) {
			answer = Math.max(answer, maxMeetings);

			if (meetings.get(i).getStart() > meetings.get(last).getEnd()) {
				maxMeetings++;
				last = i;
			}
		}

		return maxMeetings;

	}
	
	// simplest of all , no need to 2 variables answer and maxMeetings
	public static int maxMeetings3(int start[], int end[], int n) {

		int answer = 1;

		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Pair(start[i], end[i]));
		}

		Collections.sort(list, (a, b) -> a.end.compareTo(b.end));

		Pair last = list.get(0);

		for (int i = 1; i < n; i++) {
			if (list.get(i).start > last.end) {
				// meeting is possible
				answer++;
				last = list.get(i);
			}
		}

		return answer;

	}

	static class Pair {
		Integer start;
		Integer end;

		Pair(Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}

		Integer getStart() {
			return start;
		}

		Integer getEnd() {
			return end;
		}
	}

}
