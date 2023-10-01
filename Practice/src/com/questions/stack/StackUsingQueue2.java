package com.questions.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue2 {

	//By changing the pop operation.
	//Push -- Directly add the element in q1
	// pop -- Copy all the elements from q1 to q2 except the last one and then swap the q1 and q2.
	
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	public void push(Integer element) {
		q1.add(element);
	}

	public Integer pop() {

		while (q1.size() > 1) {
			q2.add(q1.poll());
		}
		int lastElement = q1.poll();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return lastElement;
	}

	public Integer getSize() {
		return q1.size();
	}
}
