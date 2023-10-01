package com.questions.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class ReversePolishNotation {

	public static void main(String[] args) {

		//String tokens[] = { "2", "1", "+", "3", "*" };

		String tokens[] = { "4", "13", "5", "/", "+" };

		System.out.println(new ReversePolishNotation().evalRPN(tokens));

	}

	public int evalRPN(String[] tokens) {

		List<String> list = Arrays.asList("+", "-", "*", "/");

		Stack<Integer> stack = new Stack<>();
		int result = 1;

		for (int i = 0; i < tokens.length; i++) {

			if (list.contains(tokens[i])) {

				String operator = tokens[i];
				int one = stack.pop();
				int two = stack.pop();

				if (operator.equals("+")) {
					result = one + two;
				} else if (operator.equals("-")) {
					result = two - one;
				} else if (operator.equals("*")) {
					result = one * two;
				} else {
					result = two / one;
				}

				stack.push(result);

				//System.out.println(result);

			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}

		}

		return result;

	}

}
