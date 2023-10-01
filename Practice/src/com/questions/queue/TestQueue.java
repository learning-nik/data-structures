package com.questions.queue;

public class TestQueue {

	public static void main(String[] args) {

		//queueUsingLL();
		
		//queueUsingStack1();
		
		
		queueUsingStack2();
	}

	private static void queueUsingStack2() {
		QueueUsingStack2 q3 = new QueueUsingStack2();
		q3.add(1);
		q3.add(2);
		q3.add(3);
		
		System.out.println(q3.poll());
		System.out.println(q3.poll());
		System.out.println(q3.poll());
		
		System.out.println(q3.size());
	}

	private static void queueUsingStack1() {
		QueueUsingStack q2 = new QueueUsingStack();
		q2.add(1);
		q2.add(2);
		q2.add(3);
		
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		
		System.out.println(q2.size());
		
		System.out.println("--------------------------------------------");
	}

	private static void queueUsingLL() {
		QueueUsingLinkedList q1 = new QueueUsingLinkedList();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		
		System.out.println(q1.poll());
		System.out.println(q1.poll());
		
		System.out.println(q1.size());
		
		System.out.println("--------------------------------------------");
	}

}
