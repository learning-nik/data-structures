package com.questions.threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor {

	private final BlockingQueue<Runnable> workerQueue;
	private final Thread[] workerThreads;

	public CustomThreadPoolExecutor(int numThreads) {
		workerQueue = new LinkedBlockingQueue<>();
		workerThreads = new Thread[numThreads];
		int i = 0;
		for (Thread t : workerThreads) {
			t = new Worker("Custom Pool Thread " + ++i);
			t.start();
		}
	}

	public void addTask(Runnable r) {
		workerQueue.add(r);
	}

	class Worker extends Thread {
		public Worker(String name) {
			super(name);
		}

		public void run() {
			while (true) {
				try {
					workerQueue.take().run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		CustomThreadPoolExecutor threadPoolExecutor = new CustomThreadPoolExecutor(100);
		threadPoolExecutor.addTask(() -> System.out.println("First print task"));
		threadPoolExecutor.addTask(() -> System.out.println("Second print task"));
	}

}
