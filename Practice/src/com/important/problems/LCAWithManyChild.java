package com.important.problems;

import java.util.Arrays;
import java.util.List;

// LCA for n-ary tree , tree with more than 2 children
public class LCAWithManyChild {
	
	// this only works fine if all the nodes are present in the tree
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(20);
		TreeNode rootNext1 = new TreeNode(10);
		TreeNode rootNext2 = new TreeNode(15);

		root.children = Arrays.asList(new TreeNode[] { rootNext1, rootNext2 });

		TreeNode level2Child1 = new TreeNode(11);
		TreeNode level2Child2 = new TreeNode(12);
		TreeNode level2Child3 = new TreeNode(13);

		rootNext1.children = Arrays.asList(new TreeNode[] { level2Child1, level2Child2, level2Child3 });

		TreeNode level2RightChild1 = new TreeNode(31);
		TreeNode level2RightChild2 = new TreeNode(41);

		rootNext2.children = Arrays.asList(new TreeNode[] { level2RightChild1, level2RightChild2 });

		TreeNode answer = firstCommonAncester(root, level2Child1, level2Child3);
		
		//TreeNode answer = firstCommonAncester(root, new TreeNode(100), level2Child3);

		System.out.println(answer);
		if(answer !=null) {
			System.out.println(answer.val);
		}

		

	}

	private static TreeNode firstCommonAncester(TreeNode root, TreeNode one, TreeNode two) {

		System.out.println("parent is: "+root.val);

		if (root==null || root.val == one.val || root.val == two.val) {
			return root;
		}

		if (root.children == null || root.children.size() == 0) {
			return null;
		}

		int count = 0;
		TreeNode lastNode = null;
		for (TreeNode child : root.children) {
			TreeNode node = firstCommonAncester(child, one, two);
			if (node != null) {
				count++;
				lastNode = node;
				// store the node
			}

		}
		
		// this means 2 nodes have been found for the parent , equal to the two other nodes
		if (count == 2) {
			return root;
		}

		return lastNode;

	}

	static class TreeNode {
		int val;
		List<TreeNode> children;

		TreeNode(int val) {
			this.val = val;
		}
	}

}
