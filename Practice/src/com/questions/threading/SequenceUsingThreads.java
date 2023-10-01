package com.questions.threading;

public class SequenceUsingThreads extends Thread {

	static Object lock=new Object();
	int rem;
	static int count = 1;

	SequenceUsingThreads(int rem) {
		this.rem = rem;
	}

	@Override
	public void run() {
		while (count <= 20) {
			//synchronized (SequenceUsingThreads.class) {
			synchronized (lock) {
				if (count % 3 != rem) {
					try {
						lock.wait();
						//System.out.println(Thread.currentThread().getName()+": I am Waiting");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(Thread.currentThread().getName()+": "+count);
					count++;
					lock.notifyAll();
				}
			}
		}
	}

	public static void main(String[] args) {

		SequenceUsingThreads t1 = new SequenceUsingThreads(1);
		SequenceUsingThreads t2 = new SequenceUsingThreads(2);
		SequenceUsingThreads t3 = new SequenceUsingThreads(0);

		t1.start();
		t2.start();
		t3.start();
	}

}
