package com.questions.string;

public class CommonStrings {

	public static void main(String[] args) {

		/*String main = "sadbutsad";
		String sub = "sad";*/

		String main = "leetleeto";
		String sub = "leeto";

		System.out.println(new CommonStrings().strStr(main, sub));
		//System.out.println("sadbutsad".substring(0,"sad".length()));
	}

	public int strStr(String main, String sub) {

		int subLength = sub.length();
		for (int i = 0; i <= main.length() - subLength; i++) {
			//System.out.println(main.substring(i, subLength + i));
			if (main.substring(i, subLength + i).equals(sub)) {
				return i;
			}
		}
		return -1;

	}

}
