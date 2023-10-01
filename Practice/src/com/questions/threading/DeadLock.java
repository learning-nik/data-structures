package com.questions.threading;

public class DeadLock {

	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();

	}

	static class Thread1 extends Thread {
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println(Thread.currentThread().getName() + ": is having lock1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println(Thread.currentThread().getName() + ": is having lock1 and lock2");
				}
			}
			System.out.println(Thread.currentThread().getName() + ": released both locks");
		}
	}

	static class Thread2 extends Thread {
		@Override
		public void run() {
			synchronized (lock2) {
				System.out.println(Thread.currentThread().getName() + ": is having lock2");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println(Thread.currentThread().getName() + ": is having lock2 and lock1");
				}
			}
			System.out.println(Thread.currentThread().getName() + ": released both locks");
		}
	}

}