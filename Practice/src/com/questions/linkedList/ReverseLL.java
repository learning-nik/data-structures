package com.questions.linkedList;

import com.questions.linkedList.CustomLinkedList.Node;

public class ReverseLL {

	public static void main(String[] args) {

		CustomLinkedList list1 = new CustomLinkedList();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		printList(list1.head);

		//printList(reverseListIterative(list1.head));

		printList(reverseUsingRecurssion(list1.head));
	}

	public static Node reverseListIterative(Node head) {

		Node prev = null;
		Node next = null;
		Node current = head;

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}
		return prev;

	}
	
	static Node reverseUsingRecurssion(Node node) {
		
		if(node ==null || node.next==null) {
			return node;
		}
		
		Node newHead = reverseUsingRecurssion(node.next);
		Node newTail =node.next;
		newTail.next=node;
		node.next=null;
		
		return newHead;
		
		
	}

	private static void printList(Node sortedList) {
		
		System.out.println("--------------");
		
		Node current = sortedList;
		while (current != null) {
			System.out.print(current.data+", ");
			current = current.next;

		}
	}

}
