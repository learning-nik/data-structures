package com.questions.string;

public class ReverseInteger {

	public static void main(String[] args) {

		//new ReverseInteger().reverse(123);

		/*String[] event1 = { "01:15", "02:00" };
		String[] event2 = { "02:00", "03:00" };*/
		
		String[] event1 = { "10:00", "11:00" };
		String[] event2 = { "14:20", "15:00" };

		System.out.println(new ReverseInteger().haveConflict(event1, event2));
	}

	public int reverse(int x) {
		boolean flag = false;
		String sfinal = "";

		String value = String.valueOf(x);
		if (value.charAt(0) == '-') {
			value = value.substring(1);
			flag = true;
		}

		StringBuilder sb = new StringBuilder(value);
		sb.reverse();
		if (flag) {

			sfinal = "-" + sb;
		} else {
			sfinal = sb.toString();
		}

		System.out.println(sfinal);

		return Integer.parseInt(sfinal);
	}

	public boolean haveConflict(String[] event1, String[] event2) {

		if (event1[0].compareTo(event2[0]) < 0) {
			System.out.println("IN 1");
			System.out.println(event1[1].compareTo(event2[0]));
			return !(event1[1].compareTo(event2[0]) < 0);
		} else {
			return !(event2[1].compareTo(event1[0]) < 0);
		}

	}
}
