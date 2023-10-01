package com.questions.linkedList;

public class CustomLinkedList {

	public Node head;

	public static class Node {
		Node next;
		Integer data;

		 Node(int data) {
			this.data = data;
		}
		
		public int getData() {
			return this.data;
		}
	}

	void printList() {
		System.out.println("----------------");
		Node current = this.head;
		while (current != null) {
			System.out.print(current.data+", ");
			current = current.next;
		}
	}

	void addAtStart(Integer data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	// adding element at the end of list
	void add(Integer data) {
		Node newNode = new Node(data);
		if (head != null) {
			Node check = head;

			while (check.next != null) {
				check = check.next;
			}
			check.next = newNode;
		} else {
			head = newNode;
		}
	}

	void addAt(Integer index, Integer data) {
		Node newNode = new Node(data);
		if (index < size() && index != 0) {
			Node check = head;
			int count = 0;
			while (count < index - 1) {
				count++;
				check = check.next;
			}
			Node temp = check.next;
			check.next = newNode;
			newNode.next = temp;
		} else {
			if (index == 0) {
				newNode.next = head;
				head = newNode;
			} else {
				System.out.println("please mention correct index");
				throw new RuntimeException();
			}
		}
	}

	int size() {
		Node check = head;
		int size = 0;
		while (check != null) {
			size++;
			check = check.next;
		}
		// System.out.println("size is: "+size);
		return size;
	}

	void reverse() {
		Node current = head;
		Node prev = null;
		Node next = null;

		while (current != null) {
			next = current.next; // set the next pointer
			current.next = prev; // change the next pointer
			prev = current; // move one step ahead
			current = next;
		}
		head = prev;

		/*
		 * ------- Implementation using Stack ... Push data into stack then pop
		 * it.....-------------- Stack<String> stack = new Stack<>();
		 * while(current!=null) { stack.push(current.data); current=current.next; }
		 * current=head; while(current!=null) { current.data=stack.pop();
		 * current=current.next; }
		 */
	}
	
	

	void findNodeFromLast(int n) {

		Node one = head, two = head;

		for (int i = 0; i < n - 1; i++) {
			two = two.next;
		}
		while (two.next != null) {
			one = one.next;
			two = two.next;
		}
		System.out.println(one.data);
	}

	void delete(Integer data) {

		Node check = head;
		if (check.data.equals(data)) {
			head = check.next;
		} else {
			while (check.next.data != data) {
				check = check.next;
			}
			check.next = check.next.next;
		}
	}

	/**
	 * Use two pointers both pointing at head.Slow pointer will travel one node and
	 * other will travel 2 nodes till the second pointer reaches the end.First node
	 * represents middle element.
	 */
	void middleElement() {

		Node one = head, two = head;
		int flag = 0;
		while (two.next != null) {
			if (two.next != null && two.next.next == null) {
				flag = 1;
				break;
			} else {
				one = one.next;
				two = two.next.next;
			}
		}
		if (flag == 1) {
			System.out.println("middle elements are:" + one.data + " and " + one.next.data);
		} else
			System.out.println("Middle element is :" + one.data);
	}

	/**
	 * This only works for a sorted linked list.
	 */
	void deleteDuplicates() {
		Node one = head, two = head.next;
		while (two != null) {
			if (!(two.data).equals(one.data)) {
				one.next = two;
				one = two;
				two = two.next;
			} else {
				if (two.next == null && two.data.equals(one.data)) {
					one.next = null;
				}
				two = two.next;
			}
		}
	}

	Node deleteDuplicate(Node root) {

		Node current = root;
		Node previous = root;
		// while(current!=null){

		while (current.next != null) {

			if (current.next.data == previous.data) {
				current = current.next;
			} else {
				previous.next = current.next;
				previous = previous.next;
			}
		}
		previous.next = null;
		/*
		 * if(current.data == previous.data ) { previous.next=null; } else {
		 * previous.next=current; //previous.next=null; }
		 */
		return root;

	}
}
