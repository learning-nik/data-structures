package test;

public class Recurssion {

	public static void main(String[] args) {

		int n = 4;
		System.out.println(factorial(n));
		
	}

	private static int factorial(int i) {

		if (i != 0) {

			return (i * factorial(i - 1));
		} else
			return 1;
	}

}
