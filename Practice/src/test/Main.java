package test;

public class Main {

	public static void main(String[] args) {

		Main main = new Main();
		Sub sub = new Sub();
		Main mainSub = new Sub();
		//Sub subMain = (Sub) new Main();

		main.test();
		sub.test();
		mainSub.test();
		//subMain.test();

	}

	void test() {
		System.out.println("IN MAIN");
	}

}

class Sub extends Main {

	public void test() {
		System.out.println("IN SUB");
	}
}
