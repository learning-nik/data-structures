package com.questions.queue;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	public void add(Integer element) {
		
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(element);
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
	
	public Integer poll() {
		return stack1.pop();
	}
	
	public int size() {
		return stack1.size();
	}
}
