package com.questions.threading;

import java.util.concurrent.LinkedBlockingQueue;

//https://medium.com/@itsmynameangad/java-build-your-own-custom-executorservice-threadpool-213e46159326

public class ExecutorServiceCustom {
	public static void main(String[] args) {
		MyExecutorService service = MyExecutors.myNewFixedThreadPool(3);
		for (int i = 0; i < 20; i++) {
			service.submit(new Mytask(i));
		}
	}
}

interface MyExecutorService {
	void submit(Runnable r);
}

class MyThreadPool implements MyExecutorService {
	static int capacity;
	static int currentCapacity;
	static LinkedBlockingQueue<Runnable> linkedBlockingQueue;
	Execution e;

	public MyThreadPool(int capacity) {
		this.capacity = capacity;
		currentCapacity = 0;
		linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
		e = new Execution();
	}

	@Override
	public void submit(Runnable r) {
		linkedBlockingQueue.add(r);
		e.executeMyMethod();
	}
}

class Execution implements Runnable {
	void executeMyMethod() {
		if (MyThreadPool.currentCapacity < MyThreadPool.capacity) {
			MyThreadPool.currentCapacity++;
			Thread t = new Thread(new Execution());
			t.start();
		}
	}

	@Override
	public void run() {
		while (true) {
			if (MyThreadPool.linkedBlockingQueue.size() != 0) {
				MyThreadPool.linkedBlockingQueue.poll().run();
			}
		}
	}
}

class MyExecutors {
	int capacity;

	static MyExecutorService myNewFixedThreadPool(int capacity) {
		return new MyThreadPool(capacity);
	}
}

class Mytask implements Runnable {

	int taskId;

	public Mytask(int id) {
		taskId = id;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "::Task :: " + taskId);
	}
}
