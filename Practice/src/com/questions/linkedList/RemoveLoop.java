package com.questions.linkedList;

import com.questions.linkedList.CustomLinkedList.Node;

public class RemoveLoop {
	
	public static void main(String[] args) {
		
		CustomLinkedList list = new CustomLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		removeLoop(list.head);
	}

	public static void removeLoop(Node head) {

		if (head == null) {
			return;
		}

		Node slow = head;
		Node fast = head;

		while (slow.next != null && fast.next!=null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (slow.next != fast.next) {
					slow = slow.next;
					fast = fast.next;
				}
				fast.next = null;
			}
		}
	}

}
