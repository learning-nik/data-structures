package com.questions.linkedList;

import com.questions.linkedList.CustomLinkedList.Node;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {

		CustomLinkedList list = new CustomLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);

		int n = 1;

		Node head = new RemoveNthNodeFromEnd().removeNthFromEnd(list.head, n);

		//Node head1 = new RemoveNthNodeFromEnd().removeNthFromEndUsing2Pointers(list.head, n);

		printList(head);

	}

	public Node removeNthFromEnd(Node head, int n) {

		Node temp = head;
		int size = 0;

		while (temp != null) {
			size++;
			temp = temp.next;
		}

		int nodeFromStart = size - n;

		Node current = null;

		for (int i = 0; i < nodeFromStart; i++) {

			if (current != null) {
				current = current.next;
			} else {
				current = head;
			}

			current = current.next;
		}

		if (current == null) {
			return head.next;
		}

		current.next = current.next.next;

		return head;

	}

	public Node removeNthFromEndUsing2Pointers(Node head, int n) {

		Node fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		if (fast == null)
			return head.next;

		Node slow = head;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;

		return head;

	}

	private static void printList(Node sortedList) {
		Node current = sortedList;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;

		}
	}

}
