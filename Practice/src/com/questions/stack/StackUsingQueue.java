package com.questions.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	//By changing the Push operation.
	//Push -- Directly add the element in q2 then copy all the remaining elements in q1 to q2 and swap them.
	// pop -- Just take the last element from q1.
	
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	public void push(Integer element) {
		q2.add(element);
		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	public Integer pop() {
		return q1.poll();
	}

	public Integer getSize() {
		return q1.size();
	}
}
