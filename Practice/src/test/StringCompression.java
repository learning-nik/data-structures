package test;

import java.util.ArrayList;
import java.util.List;

//443. String Compression
//https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
public class StringCompression {

	public static void main(String[] args) {

		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };

		 //char[] chars = { 'a' };

		//char[] chars = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };

		int length = compress(chars);
		
		//System.out.println(length);

		for (int i = 0; i < length; i++) {
			System.out.println(chars[i] + ": ");
		}
	}

	public static int compress(char[] chars) {

		int i = 0;
		int j = 1;
		int count = 1;

		//char[] answer = new char[chars.length];
		int len = 0;
		while (j < chars.length) {

			if (chars[i] == chars[j]) {
				j++;
				count++;
			} else {
				chars[len++] = chars[i];
				if (count != 1) {

					for (char c : Integer.toString(count).toCharArray()) {
						chars[len++] = c;

					}

				}
				i = j;
				j++;
				count = 1;
			}
		}
		chars[len++] = chars[i];
		if (count != 1) {
			for (char c : Integer.toString(count).toCharArray()) {
				chars[len++] = c;
			}
		}

		//chars = answer;
		

		/*for (int k = 0; k < answer.length; k++) {
			System.out.println(answer[k] + ": ");
		}*/
		
		/*for (int k = 0; k < len; k++) {
			chars[k] = answer[k];
		}*/

		return len;


	}
}
