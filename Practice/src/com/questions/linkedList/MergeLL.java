package com.questions.linkedList;

import com.questions.linkedList.CustomLinkedList.Node;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeLL {

	public static void main(String[] args) {

		CustomLinkedList list1 = new CustomLinkedList();
		list1.add(1);
		list1.add(2);

		CustomLinkedList list2 = new CustomLinkedList();
		list2.add(1);
		list2.add(3);
		list2.add(4);

		Node sortedList = mergeTwoLists(list1.head, list2.head);

		printList(sortedList);

	}

	public static Node mergeTwoLists(Node list1, Node list2) {

		Node head = list1;
		Node current = list1;
		Node one = list1;
		Node two = list2;

		if (two.data < one.data) {
			head = list2;
			current = list2;
			two = two.next;

		} else {
			one = one.next;
		}

		while (one != null && two != null) {

			if (two.data < one.data) {

				current.next = two;
				current = two;
				two = two.next;

			} else {

				current.next = one;
				current = one;
				one = one.next;

			}

		}

		// add the remaining elements if left in any of the list.
		if (one != null) {
			current.next = one;

		} else {
			current.next = two;
		}

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
