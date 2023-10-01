package com.questions.threading;

public class EvenAndOddUsingThreads {

	volatile int count = 1;

	void printEven() {
		/*try {
			//Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		synchronized (this) {
			while (count <= 10) {
				if (count % 2 != 0) {
					try {
						System.out.println(Thread.currentThread().getName() + " is waiting as count = " + count);
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " is not waiting as count is " + count);
				System.out.println(Thread.currentThread().getName()+": "+count);
				count++;
				notify();
			}

		}
	}

	void printOdd() {
		synchronized (this) {
			while (count <= 10) {
				if (count % 2 == 0) {
					try {
						System.out.println(Thread.currentThread().getName() + " is waiting as count = " + count);
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " is not waiting as count is " + count);
				System.out.println(Thread.currentThread().getName()+": "+count);
				count++;
				notify();
			}

		}
	}

	public static void main(String[] args) {

		EvenAndOddUsingThreads obj = new EvenAndOddUsingThreads();
		Thread t1 = new Thread(() -> obj.printOdd());
		Thread t2 = new Thread(() -> obj.printEven());
		t1.setName("ODD-THREAD");
		t2.setName("EVEN-THREAD");
		t1.start();
		t2.start();
	}

}
