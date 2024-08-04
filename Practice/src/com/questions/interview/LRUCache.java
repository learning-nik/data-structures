package com.questions.interview;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {

            updateNodeAndAddToTail(map.get(key));
            return map.get(key).val;

        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node lastNode = map.get(key);
            lastNode.val = value;
            updateNodeAndAddToTail(lastNode);
            map.put(key, lastNode);

        } else {
            // If capacity is available , just add the element to end to list and to the map.
            if (map.size() < capacity) {
                Node node = new Node(key, value, null, null);
                addNodeAtTail(node);
                map.put(key, node);
            } else {

                // If capacity is not available ,
                // Remove the element from the head of LL and from map.
                // Add the element to end to list and to the map.
                Node node = new Node(key, value, null, null);
                Node lastHead = removeNodeFromHead();
                map.remove(lastHead.key);
                addNodeAtTail(node);
                map.put(key, node);

            }
        }
    }

    private void updateNodeAndAddToTail(Node node) {

        if (node.val != tail.val) {

            Node tempPrev = node.prev;
            Node tempNext = node.next;

            if (head.val == node.val) {
                head = tempNext;
            }

            if (tempPrev != null) {
                tempPrev.next = tempNext;
            }

            if (tempNext != null) {
                tempNext.prev = tempPrev;
            }

            addNodeAtTail(node);
        }

    }

    private void addNodeAtTail(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
            tail.next = null;
        }

    }

    private Node removeNodeFromHead() {

        Node lastHead = head;
        lastHead.prev = null;
        head = head.next;

        return lastHead;

    }

    class Node {

        private final int key;
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
}
