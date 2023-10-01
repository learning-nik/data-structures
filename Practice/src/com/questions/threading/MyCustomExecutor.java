package com.questions.threading;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyCustomExecutor {

	public static void main(String[] args) {

		ExecutorService threadPoolExecutor = MyExecutor.newThreadPool(3);
		for (int i = 0; i < 10; i++) {
			threadPoolExecutor.submit(() -> {
				System.out.println();
			});
		}
	}
}

interface ExecutorService {

	void submit(Runnable run);
}

class ThreadPoolExecutor implements ExecutorService {

	int capacity;
	Queue<Runnable> queue;

	public ThreadPoolExecutor(int capacity) {
		this.capacity = capacity;
		queue = new LinkedBlockingQueue<>();
	}

	@Override
	public void submit(Runnable task) {
		queue.add(task);
		
		//if()
	}

}

class MyExecutor {

	public static ExecutorService newThreadPool(int capacity) {
		return new ThreadPoolExecutor(capacity);
	}

}
