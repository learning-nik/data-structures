package com.questions.string;

//DSA VIDEOS
//https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&id=leetcode-75
public class ReverseWordsInString {

	public static void main(String[] args) {

		String s = "I LOVE CODING IN JAVA";
		System.out.println(reverseWords(s));

		//String s = "  hello world  ";
		//String s = "the sky is blue";
		//String s = "a good   example";
	}

	// Leetcode
	public static String reverseWords(String s) {

		String sNew = s.trim();
		//System.out.println(sNew);

		String[] a = sNew.split(" ");

		/*for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}*/

		int left = 0;
		int right = a.length - 1;

		while (left < right) {
			String temp = a[left];
			a[left] = a[right];
			a[right] = temp;

			left++;
			right--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {

			if (!a[i].isEmpty()) {

				sb.append(a[i]);

				if (i != a.length - 1) {
					sb.append(" ");
				}
			}
		}

		return sb.toString();

	}

}
