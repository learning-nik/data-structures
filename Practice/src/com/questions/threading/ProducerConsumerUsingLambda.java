package com.questions.threading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerUsingLambda {

	public static int MAX_SIZE = 5;

	List<Integer> sharedList = new ArrayList<>();

	void produce(int i) {

		synchronized (sharedList) {
			try {
				if (sharedList.size() == MAX_SIZE) {
					sharedList.wait();
					System.out.println("QUEUE IS FULL ... WAITING FOR ELEMENT TO BE REMOVED");
				} else {
					Thread.sleep(1000);
					sharedList.add(i);
					System.out.println("ELEMENT ADDED TO QUEUE");
					sharedList.notify();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	void consume() {
		synchronized (sharedList) {
			try {
				if (sharedList.size() == 0) {
					sharedList.wait();
					System.out.println("QUEUE IS EMPTY....WAITING FOR ELEMENTS TO BE ADDED");
				} else {
					Thread.sleep(1000);
					sharedList.remove(0);
					System.out.println("ELEMENT REMOVED");
					sharedList.notify();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		ProducerConsumerUsingLambda pc = new ProducerConsumerUsingLambda();
		Thread t1 = new Thread(() -> {
			int i = 0;
			while (true)
				pc.produce(i++);
		});
		Thread t2 = new Thread(() -> {
			while (true)
				pc.consume();
		});
		t1.start();
		t2.start();
		
	}
}
