package com.questions.stack;

public class TestCustomStack {

	public static void main(String[] args) {
		CustomStack stack = new CustomStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		/*stack.push(4);
		stack.push(5);*/
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		stack.push(10);
		stack.push(11);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("LENGTH IS: "+stack.getLength());
		
		/*StackUsingQueue stack1 = new StackUsingQueue();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		
		
		System.out.println("LENGTH IS: "+stack1.getSize());
		
		
		StackUsingQueue2 stack2 = new StackUsingQueue2();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		stack2.push(4);
		stack2.push(5);
		
		System.out.println(stack2.pop());
		System.out.println(stack2.pop());
		System.out.println(stack2.pop());
		
		
		System.out.println("LENGTH IS: "+stack2.getSize());*/
	}

}
