package com.questions.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadTypes {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		//System.out.println(Runtime.getRuntime().availableProcessors());
		
		// ------------------------------------------------------------------------------------------------
		// Thread by Runnable
		ThreadByRunnable t1 = new ThreadByRunnable();
		Thread runnableThread = new Thread(t1);
		runnableThread.start();
		
		// we can call the run method directly here but it wont start a new thread.
		//e.g t1.run() won't start a new thread. 
		
		// ------------------------------------------------------------------------------------------------

		// Thread By extending thread class
		ThreadByExtension t2 = new ThreadByExtension();
		t2.start();

		// ------------------------------------------------------------------------------------------------
		
		// Thread by Callable
		ThreadByCallable t3 = new ThreadByCallable();
		ExecutorService service = Executors.newFixedThreadPool(1);
		service.submit(t3);

		// Note :
		// Callable threads are not allowed by Thread class
		// However, Runnable instances can be run by Thread class as well
		//as ExecutorService but Callable instances can only be executed via ExecutorService.

	}

}
//can  be called by  both  ExecutorService and Thread class both

class ThreadByRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("This is by Runnable");
		

	}

}

class ThreadByExtension extends Thread {

	// No mandatory to overide run method
	// if we dont want to override the thread class then no need to create this call
	// use the thread class directly.

	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Hello i am a thread extension");
	}
}

// can only be called by ExecutorService
class ThreadByCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		System.out.println("I am a Callable thread");
		return "Hello I am back";
	}

}
