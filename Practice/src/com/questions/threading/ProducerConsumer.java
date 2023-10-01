package com.questions.threading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static int MAX_SIZE = 5;

	public static void main(String[] args) {

		List<Integer> sharedList = new ArrayList<>();
		Thread t1 = new Thread(new Producer(sharedList));
		Thread t2 = new Thread(new Consumer(sharedList));
		t2.start();
		t1.start();
		

	}
}

class Producer implements Runnable {

	List<Integer> sharedList;

	public Producer(List<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				produce(i++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	void produce(int i) throws InterruptedException {

		synchronized (sharedList) {
			if (sharedList.size() == ProducerConsumer.MAX_SIZE) {
				sharedList.wait();
				System.out.println("QUEUE IS FULL WAITING");
			} else {
				Thread.sleep(1000);
				sharedList.add(i);
				System.out.println("ELEMENT ADDED");
				sharedList.notify();
			}

		}

	}
}

class Consumer implements Runnable {

	List<Integer> sharedList;

	public Consumer(List<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	void consume() throws InterruptedException {

		synchronized (sharedList) {
			if (sharedList.size() == 0) {
				sharedList.wait();
				System.out.println("QUEUE IS EMPTY....WAITING");
			} else {
				Thread.sleep(1000);
				sharedList.remove(0);
				System.out.println("ELEMENT REMOVED");
				sharedList.notify();
			}

		}

	}

}
