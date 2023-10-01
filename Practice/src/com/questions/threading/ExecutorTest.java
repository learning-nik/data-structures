package com.questions.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(2);
		Task task = new Task();
		System.out.println(task.hashCode());
		Future<Task> future = service.submit(task);
		System.out.println(future.get().hashCode());

		
		service.submit(()->{
			//Thread.sleep(5);
		});
	}

}

class Task implements Callable<Task> {

	@Override
	public Task call() throws Exception {

		return this;
	}

}