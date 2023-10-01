package java8;

public class TestRunnable {

	public static void main(String[] args) {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread started using 1");

			}
		});

		Thread thread2 = new Thread(() -> {
			myMethod();
		}

		);

		thread.start();
		thread2.start();
	}

	private static void myMethod() {
		System.out.println("Thread started using lambda");

	}
}
