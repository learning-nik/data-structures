package com.questions.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import com.questions.tree.Practice.TreeNode;

public class BinarySearchTree {

	Node rootNode;

	public class Node {

		Integer value;
		Node left;
		Node right;

		Node(Integer value) {
			this.value = value;
		}
	}

	void add(Integer string) {

		if (rootNode != null) {

			insert(rootNode, string);
		} else {
			rootNode = new Node(string);
		}
	}

	private void insert(Node refNode, Integer value) {

		if (value.compareTo(refNode.value) == -1) {

			if (refNode.left != null) {
				insert(refNode.left, value);
			} else {
				refNode.left = new Node(value);
			}
		}

		else {

			if (refNode.right != null) {
				insert(refNode.right, value);
			} else {
				refNode.right = new Node(value);
			}
		}
	}

	// ROOT-LEFT-RIGHT
	// Hint : Pre means root comes first
	void printPreOrder(Node node) {

		if (node == null) {
			return;
		}

		System.out.print(node.value + ", ");

		printPreOrder(node.left);

		printPreOrder(node.right);
	}

	// LEFT-ROOT-RIGHT
	// Hint : It means root comes in between
	// For a BST , this prints the data in ascending order.
	void printInOrder(Node node) {

		if (node == null) {
			return;
		}

		printInOrder(node.left);

		System.out.print(node.value + ", ");

		printInOrder(node.right);

	}

	// LEFT-RIGHT-ROOT
	// Hint : Post means root comes post all	
	void printPostOrder(Node node) {

		if (node == null) {
			return;
		}

		printPostOrder(node.left);

		printPostOrder(node.right);

		System.out.print(node.value + ", ");
	}

	void printPreOrderIterative(Node node) {

		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {

			Node lastNode = stack.pop();
			System.out.print(lastNode.value + ", ");
			if (lastNode.right != null) {
				stack.push(lastNode.right);
			}
			if (lastNode.left != null) {
				stack.push(lastNode.left);
			}
		}

	}

	void printInOrderIterative(Node current) {
		Stack<Node> stack = new Stack<>();
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.value + ", ");
			current = current.right;
		}
	}

	// to be done
	// not working
	void printPostOrderIterative(Node current) {
		Stack<Node> stack = new Stack<>();

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.add(current);
				current = current.left;
			}

			Node last = stack.peek();
			current = last.right;

			if (current == null) {
				Node right = stack.pop();
				System.out.print(right.value + ", ");
				if (stack.peek().right == right) {
					System.out.print(stack.pop().value + ", ");
				}
				// current=stack.pop();
			}

		}
		// stack.add(current);
	}

	void printLevelOrderUsingQueue(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node queueNode = queue.poll();
			System.out.print(queueNode.value + ", ");

			if (queueNode.left != null) {
				queue.add(queueNode.left);
			}

			if (queueNode.right != null) {
				queue.add(queueNode.right);
			}
		}
	}

	void printLeftViewUsingQueue(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node queueNode = queue.poll();
			System.out.print(queueNode.value + ", ");

			if (queueNode.left != null) {
				queue.add(queueNode.left);
			} else if (queueNode.right != null) {
				queue.add(queueNode.right);
			}
		}
	}

	void printRightViewUsingQueue(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node queueNode = queue.poll();
			System.out.print(queueNode.value + ", ");

			if (queueNode.right != null) {
				queue.add(queueNode.right);
			} else if (queueNode.left != null) {
				queue.add(queueNode.left);
			}
		}
	}

	int getHeight(Node node) {

		if (node == null) {
			return 0;
		}

		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;

	}
	
	void nodesAtKDistanceFromRoot(Node node, int k) {

		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.println(node.value);
		} else {
			nodesAtKDistanceFromRoot(node.left, k - 1);
			nodesAtKDistanceFromRoot(node.right, k - 1);
		}

	}
	
	boolean checkIfBST(TreeNode node){
		
		if(node ==null) {
			return true;
		}
		
		return true;
		
	}
	
	
	boolean IfBST(TreeNode node, int prev){
		
		if(node ==null) {
			return true;
		}
		
		IfBST(node.left, prev);
		
		IfBST(node.right, prev);
		
		
		return true;
	}
	
	// Get Sum of nodes which are at same vertical distance.
	public Map<Integer, Integer> getNodeVerticalSum(Node node) {
		Map<Integer, Integer> map = new HashMap<>();
		getVerticalSum(node, 0, map);
		return map;

	}

	private void getVerticalSum(Node node, int dis, Map<Integer, Integer> map) {

		if (node != null) {

			getVerticalSum(node.left, dis - 1, map);
			getVerticalSum(node.right, dis + 1, map);

			if (map.containsKey(dis)) {
				map.put(dis, map.get(dis) + node.value);
			} else {
				map.put(dis, node.value);
			}

		}
	}
	
	/*	
	 * // tried with inorder  but some test cases are failing in GFG.
		public ArrayList<Integer> verticalOrderTest(Node root) {
			ArrayList<Integer> list = new ArrayList<>();
			Map<Integer, List<Integer>> map = new TreeMap<>();
			inOrder(root, 0, map);
			for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
				for (Integer value : entry.getValue()) {
					list.add(value);
				}
			}
			return list;
		}
	
	
		private void inOrder(Node root, int dis, Map<Integer, List<Integer>> map) {
			if (root == null) {
				return;
			}
	
			if (map.containsKey(dis)) {
				List<Integer> set = map.get(dis);
				set.add(root.value);
				map.put(dis, set);
	
			} else {
				List<Integer> set = new ArrayList<>();
				set.add(root.value);
				map.put(dis, set);
			}
	
			inOrder(root.left, dis - 1, map);
			inOrder(root.right, dis + 1, map);
	
		}*/
    
    
    public ArrayList <Integer> verticalOrder(Node root)
	{
		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer, List<Integer>> map = new TreeMap<>();
		levelOrder(root, map);
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			for (Integer value : entry.getValue()) {
				list.add(value);
			}
		}
		return list;
	}
    
    
    private void levelOrder(Node root,Map<Integer,List<Integer>> map )
	{
		if (root == null) {
			return;
		}
		Queue<NodeWrapper> queue = new LinkedList<>();
		queue.add(new NodeWrapper(root, 0));
		while (!queue.isEmpty()) {
			NodeWrapper lastWrapper = queue.poll();
			Node last = lastWrapper.node;
			int dis = lastWrapper.dis;

			if (map.containsKey(dis)) {
				List<Integer> set = map.get(dis);
				set.add(last.value);
				map.put(dis, set);

			} else {
				List<Integer> set = new ArrayList<>();
				set.add(last.value);
				map.put(dis, set);
			}

			if (last.left != null) {
				queue.add(new NodeWrapper(last.left, dis - 1));
			}

			if (last.right != null) {
				queue.add(new NodeWrapper(last.right, dis + 1));
			}

		}
	}
    
    class NodeWrapper{
    	Node node;
    	int dis;
    	
    	public NodeWrapper(Node node , int dis) {
			this.node=node;
			this.dis = dis;
		}
    }
    
    
    public int minDiff(Node node, int K) 
    { 
        int min = Math.abs(K-node.value);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
        	
            Node last = queue.poll();
            min = Math.min(min, Math.abs(K-last.value));
            
            if(last.left!=null){
                queue.add(last.left);
            }
            
            if(last.right!=null){
                queue.add(last.right);
            }
            
        }
        
        return min;
    } 
    
    // Get the largest of the smaller element than the given one.
	// TC : O(h) , SP : O(h)
	public int floor(Node root, int key) {

		List<Integer> list = new ArrayList<>();
		list.add(-1);
		floor(root, key, list);
		return list.get(0);

	}

	private void floor(Node root, int key, List<Integer> list) {
		if (root != null) {
			if (key == root.value) {
				list.clear();
				list.add(root.value);
			}
			else if (key > root.value) {
				list.clear();
				list.add(root.value);
				floor(root.right, key, list);
			} else {
				floor(root.left, key, list);
			}
		}
	}    
	
	// Get the largest of the smaller element than the given one.
	// TC : O(h) , SP : O(1)
	
	public int floorIterative(Node root, int key) {

		Node res = null;
		while (root != null) {
			if (root.value == key) {
				return root.value;
			} else if (key > root.value) {
				res = root;
				root = root.right;
			} else {
				root = root.left;
			}
		}

		if (res != null) {
			return res.value;
		}
		return -1;
	}
}
