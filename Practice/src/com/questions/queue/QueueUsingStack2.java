package com.questions.queue;

import java.util.Stack;

// By making pop heavy
// At the time of pop check if stack2 is empty
// if stack2 is empty , get all the elements from stack1 to stack2 and pop the last one.
public class QueueUsingStack2 {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public void add(Integer element) {
		stack1.push(element);
	}

	public Integer poll() {

		if (stack2.isEmpty()) {

			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.pop();

	}

	public int size() {
		return stack1.size() + stack2.size();
	}
}
