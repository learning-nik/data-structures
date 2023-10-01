package com.questions.queue;

import java.util.LinkedList;
import java.util.List;

public class QueueUsingLinkedList {

	private List<Integer> list;

	public QueueUsingLinkedList() {
		list = new LinkedList<>();

	}

	public void add(Integer element) {
		list.add(element);
	}
	
	public Integer poll() {
		int element =list.get(0);
		list.remove(0);
		return element;
	}
	
	public int size() {
		return list.size();
	}

}
