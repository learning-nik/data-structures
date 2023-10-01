package com.questions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Practice {

	class TreeNode {

		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int value) {
			this.val = value;
		}

	}

	public static void main(String[] args) {
		Practice practice = new Practice();
		TreeNode root = practice.buildTree();
		//practice.printPreOrder(root);
		//practice.printInOrder(root);
		// practice.printPostOrder(root);
		// System.out.println(practice.getHeight(root));
		//practice.nodesAtKDisFromRoot(root, 0);
		//practice.getTreeSize(root);
		//System.out.println(practice.getTreeSize2(root));
		//System.out.println(practice.getMaxValueFromTree(root));
		// System.out.println(practice.checkIfChildSumProp(root));
		//System.out.println(practice.checkIfBalanced(root));
		// System.out.println(practice.checkIfBalancedOptimised(root));
		//TreeNode head= practice.convertToDLL(root);
		//practice.printDLL(head);
		//practice.printLevelOrder(root);
		System.out.println("*************");
		//practice.printLevelOrderSpiralUsingStack(root);
		//practice.printLevelOrderSpiral(root);

		//practice.inOrder(root);
		//System.out.println(practice.getMin1(root));
		System.out.println(practice.widthOfBinaryTree(root));

	}

	TreeNode buildTree() {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(3);
		root.right = new TreeNode(2);

		root.left.left = new TreeNode(5);
		//root.left.right = new TreeNode(3);

		//root.right.left = new TreeNode(60);
		//root.right.right = new TreeNode(9);

		/*root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(50);
		
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(70);*/

		return root;

	}

	// Root-left-Right
	void printPreOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		System.out.print(node.val + ", ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	/*	List<Integer> list = new ArrayList<>();
		
		List<Integer> printPreOrderWithList(TreeNode node) {
			preTest(node, list);
			return list;
		}
		
		void preTest(TreeNode node , List<Integer> list){
			
			if (node == null) {
				return;
			}
			list.add(node.value);
			preTest(node.left,list);
			preTest(node.right,list);
		}*/

	void printList(List<Integer> list) {
		list.forEach(value -> System.out.println(value));
		System.out.println("**************");
	}

	// left-Root-Right
	void printInOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		printInOrder(node.left);

		System.out.print(node.val + ", ");

		printInOrder(node.right);
	}

	// left-Right-Root
	void printPostOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		printPostOrder(node.left);

		printPostOrder(node.right);

		System.out.print(node.val + ", ");
	}

	int getHeight(TreeNode node) {

		if (node == null) {
			return 0;
		}
		return (1 + Math.max(getHeight(node.left), getHeight(node.right)));
	}

	// print all nodes which are k distance from root.
	void nodesAtKDisFromRoot(TreeNode node, int k) {

		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.println(node.val);
		} else {
			nodesAtKDisFromRoot(node.left, k - 1);
			nodesAtKDisFromRoot(node.right, k - 1);
		}

	}

	int count = 0;

	// count the no of nodes in a tree
	void getTreeSize(TreeNode node) {

		if (node == null) {
			return;
		}

		count++;
		System.out.println(count);

		getTreeSize(node.left);
		getTreeSize(node.right);

	}

	int getTreeSize2(TreeNode node) {

		if (node == null) {
			return 0;
		}

		int leftSize = getTreeSize2(node.left);
		int rightSize = getTreeSize2(node.right);
		return 1 + leftSize + rightSize;

	}

	// max node value from tree
	int getMaxValueFromTree(TreeNode node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int leftRightMax = Math.max(getMaxValueFromTree(node.left), getMaxValueFromTree(node.right));

		return Math.max(leftRightMax, node.val);

	}

	// child Sum prop means , sum of child nodes should be equal to parent node.
	boolean checkIfChildSumProp(TreeNode node) {

		if (node == null) {
			return true;
		}

		// If node has no children then return true
		if (node.left == null && node.right == null) {
			return true;
		}

		// If node has both children
		if (node.left != null && node.right != null) {
			if (node.left.val + node.right.val != node.val) {
				return false;
			}
		}

		//  If node has only right child
		else if (node.left == null && node.right.val != node.val) {
			return false;
		}

		// If node has only left child
		else if (node.right == null && node.left.val != node.val) {
			return false;

		}

		return checkIfChildSumProp(node.left) && checkIfChildSumProp(node.right);

	}

	//TC : O(n^2)
	// Height balanced : Diff b/w nodes height of left child and right should not be more than one.
	// Diff of height b/w left and right can be only 0 or 1 , and it should be true for every node.

	// BF sol: calcute height of left and right subtree , by calling height function and check their diff.
	boolean checkIfBalanced(TreeNode node) {

		if (node == null) {
			return true;
		}

		int lh = getHeight(node.left);
		int rh = getHeight(node.right);

		int diff = Math.abs(lh - rh);

		return diff <= 1 && checkIfBalanced(node.left) && checkIfBalanced(node.right);

	}

	// TC: O(N)
	// Optimised sol: Check for every node if it is balanced or not , if it is balanced return the height, otherwise return -1.
	// If any node is found to be not balanced , then no need to check for other nodes .
	boolean checkIfBalancedOptimised(TreeNode node) {
		return (checkBalance(node) != -1);
	}

	private int checkBalance(TreeNode node) {

		if (node == null) {
			return 0;
		}

		int lh = checkBalance(node.left);

		if (lh == -1) {
			return -1;
		}

		int rh = checkBalance(node.right);

		if (rh == -1) {
			return -1;
		}

		int diff = Math.abs(lh - rh);

		if (diff <= 1) {
			// means the node is balanced , thus return the height.
			return Math.max(lh, rh) + 1;
		} else {
			return -1;
		}

	}

	TreeNode prev = null;

	// Convert from Tree to Doubly linked list
	// Use inorder traversal
	TreeNode convertToDLL(TreeNode node) {

		if (node == null) {
			return node;
		}
		TreeNode head = convertToDLL(node.left);

		if (prev == null) {
			// This means it is first time traversal , so set the head of DLL.
			head = node;
		} else {
			// Set the right and left pointers.
			prev.right = node;
			node.left = prev;
		}

		prev = node;
		convertToDLL(node.right);
		return head;
	}

	void printDLL(TreeNode head) {

		TreeNode test = head;

		while (test != null) {
			System.out.print(test.val + " -->");
			test = test.right;
		}
	}

	void printLevelOrder(TreeNode node) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {

			TreeNode last = queue.poll();
			System.out.print(last.val + "::");
			if (last.left != null) {
				queue.add(last.left);
			}
			if (last.right != null) {
				queue.add(last.right);
			}
		}
	}

	void printLevelOrderSpiralUsingStack(TreeNode node) {

		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.add(node);

		while (!s1.isEmpty() || !s2.isEmpty()) {

			while (!s1.isEmpty()) {
				TreeNode last = s1.pop();
				System.out.print(last.val + "::");
				if (last.left != null) {
					s2.add(last.left);
				}
				if (last.right != null) {
					s2.add(last.right);
				}
			}

			while (!s2.isEmpty()) {
				TreeNode last = s2.pop();
				System.out.print(last.val + "::");
				if (last.right != null) {
					s1.add(last.right);
				}
				if (last.left != null) {
					s1.add(last.left);
				}
			}

		}
	}

	public ArrayList<Integer> inOrder(TreeNode root) {

		ArrayList<Integer> list = new ArrayList<>();
		inOrderIterative(root, list);
		printList(list);
		return list;
	}

	void inOrderIterative(TreeNode root, ArrayList<Integer> list) {

		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		//        stack.push(root);

		while (!stack.isEmpty() || current != null) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			TreeNode last = stack.pop();
			list.add(last.val);
			current = last.right;

		}

	}

	int getMin1(TreeNode node) {

		//System.out.println(min);

		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int lMin = getMin1(node.left);

		int rMIn = getMin1(node.right);

		return Math.min(node.val, Math.min(lMin, rMIn));
	}

	// not working
	public int widthOfBinaryTree(TreeNode root) {

		int width = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode last = queue.poll();
				if (last != null) {
					list.add(last.val);
				} else {
					list.add(null);
				}

				if (last != null) {
					queue.add(last.left);
				}

				if (last != null) {
					queue.add(last.right);
				}

			}
			System.out.println("**");
			list.forEach(e -> System.out.print(e + ", "));
			//System.out.print("**");

			width = Math.max(width, list.size());

		}
		return width;

	}

}
