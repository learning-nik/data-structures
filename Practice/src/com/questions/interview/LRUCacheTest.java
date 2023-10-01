package com.questions.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCacheTest {

	public static void main(String[] args) {

		new LRUCacheTest().testLRUCache();
	}

	private void testLRUCache() {
		/*LRUCacheWithList cache = new LRUCacheWithList(3);
		cache.add(1, "10");
		cache.add(2, "20");
		cache.add(1, "30");
		cache.add(4, "40");
		cache.add(5, "50");
		
		System.out.println(cache.getValue(5));*/
		
		/*		["LRUCache","put","put","get","put","get","get"]
						[[2],[2,1],[1,1],[2],[4,1],[1],[2]]*/
		
		LRUCache cache = new LRUCache(2);
		cache.put(2, 1);
		cache.put(1, 1);
		System.out.println(cache.get(2));
		cache.put(4, 1);
		System.out.println(cache.get(1));
		//System.out.println(cache.get(2));
		//System.out.println(cache.get(3));
		//System.out.println(cache.get(4));
		

		//System.out.println(cache.get(3));

		
	}

	class LRUCacheWithList {

		private int capacity;

		private Map<Integer, String> map;

		private List<Integer> list;

		public LRUCacheWithList(int capacity) {
			this.capacity = capacity;
			map = new HashMap<>();
			list = new LinkedList<>();
		}

		void add(Integer key, String value) {
			/**
			 * If element is already present in cache , then just replace it with new value
			 * and remove it from the list and add it back again , so that it comes at the
			 * last.
			 */
			if (map.containsKey(key)) {
				map.put(key, value);
				list.remove(key);
				list.add(key);
			} else {
				// If element not present in map and capacity is there , then just add it
				if (map.size() < capacity) {
					map.put(key, value);
					list.add(key);
				} else {
					// If element not present in map and capacity is not there
					// then remove the first element in the list and from the map
					// then add the new element in map and list
					Integer leastUsed = list.get(0);
					map.remove(leastUsed);
					list.remove(leastUsed);
					map.put(key, value);
					list.add(key);
				}
			}
		}

		public String getValue(Integer key) {
			System.out.println("Map SIZE is :" + map.size());
			if (map.containsKey(key)) {
				return map.get(key);
			} else {
				return null;
			}

		}
	}

	class LRUCacheWithLL {

		class Node {
			private int key;
			private int val;
			private Node prev;
			private Node next;

			public Node(int key, int val, Node prev, Node next) {
				this.key = key;
				this.val = val;
				this.prev = prev;
				this.next = next;
			}

		}

		private int capacity;
		private Map<Integer, Node> map;
		private Node head;
		private Node tail;

		public LRUCacheWithLL(int capacity) {
			this.capacity = capacity;
			map = new HashMap<>(capacity);

		}

		public int get(int key) {

			if (map.containsKey(key)) {

				updaeNodeAndAddToTail(map.get(key));

			}
			return -1;
		}

		public void put(int key, int value) {

			if (map.containsKey(key)) {

				Node lastNode = map.get(key);
				lastNode.val = value;
				updaeNodeAndAddToTail(lastNode);
				map.put(key, lastNode);

			}

			else {
				// If capacity is available , just add the element to end to list and to the map.
				if (capacity < map.size()) {
					Node node = new Node(key, value, null, null);
					addNodeAtTail(node);
					map.put(key, node);
				} else {

					// If capacity is not available ,
					// remove the element from the head of LL and from map.
					// add the element to end to list and to the map.
					Node node = new Node(key, value, null, null);
					Node lastHead = removeNodeFromHead();
					map.remove(lastHead.key);
					addNodeAtTail(node);
					map.put(key, node);

				}
			}

		}

		private void updaeNodeAndAddToTail(Node node) {

			Node tempPrev = node.prev;
			Node tempNext = node.next;
			tempPrev.next = tempNext;
			tempNext.prev = tempPrev;

			addNodeAtTail(node);

		}

		private void addNodeAtTail(Node node) {

			if (head == null) {
				head = node;
				tail = node;
			} else {
				tail.next = node;
				node.prev = tail;
				tail = tail.next;
			}

		}

		private Node removeNodeFromHead() {

			Node lastHead = head;
			head = head.next;
			head.prev = null;

			return lastHead;

		}
	}
}
