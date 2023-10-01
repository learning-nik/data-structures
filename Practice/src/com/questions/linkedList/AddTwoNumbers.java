package com.questions.linkedList;

import com.questions.linkedList.CustomLinkedList.Node;

/*https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
*/public class AddTwoNumbers {

	public static void main(String[] args) {

		CustomLinkedList list1 = new CustomLinkedList();
		list1.add(5);
		list1.add(6);
		list1.add(3);
		list1.add(9);

		CustomLinkedList list2 = new CustomLinkedList();
		list2.add(2);
		list2.add(4);
		list2.add(8);

		Node head = new AddTwoNumbers().addTwoNumbers(list1, list2);

		printList(head);

	}

	private Node addTwoNumbers(CustomLinkedList list1, CustomLinkedList list2) {

		int carry = 0;
		Node current1 = list1.head;
		Node current2 = list2.head;
		Node newHead = null;
		Node pointer = null;
		boolean firstPass = true;

		while (carry != 0 || current1 != null || current2 != null) {
			int sum = carry;
			if (current1 != null) {
				sum += current1.data;
				current1 = current1.next;
			}

			if (current2 != null) {
				sum += current2.data;
				current2 = current2.next;
			}

			Node node = new Node(sum % 10);
			carry = sum / 10;

			if (firstPass) {
				newHead = node;
				firstPass = false;
				pointer = node;
			} else {
				pointer.next = node;
				pointer = pointer.next;
			}
		}

		return newHead;
	}

	private static void printList(Node head) {

		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

}
