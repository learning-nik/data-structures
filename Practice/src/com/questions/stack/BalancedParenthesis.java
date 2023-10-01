package com.questions.stack;

import java.util.Stack;

/*https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
*/public class BalancedParenthesis {

	public static void main(String[] args) {

		//String s = "([{}])";
		//String s = "[()]{}{[()()]()}";
		String s = "(])";
		System.out.println(checkForBalanced(s));

	}

	private static boolean checkForBalanced(String s) {
		int flag = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char present = s.charAt(i);
			if (present == '(' || present == '[' || present == '{') {
				stack.push(present);
			}

			else if (stack.isEmpty()) {
				return false;
			}

			else if (present == ')') {
				char last = stack.pop();
				if (last != '(') {
					flag = 1;
					break;
				}
			} else if (present == ']') {
				char last = stack.pop();
				if (last != '[') {
					flag = 1;
					break;
				}

			} else if (present == '}') {
				char last = stack.pop();
				if (last != '{') {
					flag = 1;
					break;
				}
			}

		}
		return !(flag == 1 || !stack.isEmpty()); 

	}
}
