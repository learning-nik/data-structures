package com.questions.interview;

//https://leetcode.com/problems/design-browser-history/description/
public class BrowserHistory {

	Node head = null;
	Node current = null;

	public BrowserHistory(String homepage) {

		Node node = new Node(homepage, null, null);
		head = node;
		current = node;

	}

	public void visit(String url) {

		Node nextUrl = new Node(url, current, null);
		current.next = nextUrl;
		current = current.next;

	}

	public String back(int steps) {

		while (steps >= 1) {
			if (current.prev == null) {
				break;
			}
			current = current.prev;
			steps--;
		}

		return current.url;

	}

	public String forward(int steps) {
		//System.out.println("current is: "+current.url);

		int count = 0;

		while (count < steps) {
			if (current.next == null) {
				break;
			}
			current = current.next;
			count++;
		}

		return current.url;

	}

	class Node {

		String url;
		Node prev;
		Node next;

		public Node(String url, Node prev, Node next) {
			this.url = url;
			this.prev = prev;
			this.next = next;
		}

	}

	public static void main(String[] args) {
		/*BrowserHistory browser = new BrowserHistory("leetcode.com");
		browser.visit("google.com");
		browser.visit("fb.com");
		browser.visit("youtube.com");
		System.out.println(browser.back(1));
		System.out.println(browser.back(1));
		System.out.println(browser.forward(1));
		browser.visit("linkedin.com");
		System.out.println(browser.forward(2));
		System.out.println(browser.back(2));
		System.out.println(browser.back(7));*/

		BrowserHistory browser = new BrowserHistory("zav.com");
		browser.visit("kni.com");
		System.out.println(browser.back(7));
		System.out.println(browser.back(7));
		System.out.println(browser.forward(5));
		System.out.println(browser.forward(1));
		browser.visit("pwrrbnw.com");
		browser.visit("mosohif.com");
		System.out.println(browser.back(9));

		//		["BrowserHistory","visit","back","back","forward","forward","visit","visit","back"]

		//		[["zav.com"],["kni.com"],[7],[7],[5],[1],["pwrrbnw.com"],["mosohif.com"],[9]]

	}
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage); obj.visit(url); String
 * param_2 = obj.back(steps); String param_3 = obj.forward(steps);
 */
