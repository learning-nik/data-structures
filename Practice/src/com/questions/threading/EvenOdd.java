package com.questions.threading;

public class EvenOdd {

	private volatile int count = 1;

	void printEvent() {
		while (count < 20) {
			synchronized (this) {
				if (count % 2 == 0) {
					//Thread.sleep(2000);
					System.out.println(count + " is Printed By:" + Thread.currentThread().getName());
					count++;
					notify();

				} else {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	void printOdd() {

		while (count < 20) {
			synchronized (this) {
				if (count % 2 != 0) {
					System.out.println(count + " is Printed By:" + Thread.currentThread().getName());
					count++;
					notify();

				} else {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		EvenOdd obj = new EvenOdd();
		Thread t1 = new Thread(() -> obj.printEvent());
		Thread t2 = new Thread(() -> obj.printOdd());
		t1.setName("EVEN_THREAD");
		t2.setName("ODD_THREAD");
		t1.start();
		t2.start();

	}

}
