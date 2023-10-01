package com.questions.tree;

import java.util.List;

public class TestBST {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);
		bst.add(14);
		bst.add(15);
		bst.add(13);

		bst.add(7);
		bst.add(8);
		bst.add(5);
		bst.add(6);

		/*bst.printPreOrder(bst.rootNode);
		System.out.println();
		bst.printPreOrderIterative(bst.rootNode);*/

		/*bst.printInOrder(bst.rootNode);
		System.out.println();
		bst.printInOrderIterative(bst.rootNode);*/

		/*bst.printPostOrder(bst.rootNode);	
		System.out.println();
		bst.printPostOrderIterative(bst.rootNode);*/

		//bst.printLevelOrderUsingQueue(bst.rootNode);
		//bst.nodesAtKDistanceFromRoot(bst.rootNode, 4);

		/*bst.printLeftViewUsingQueue(bst.rootNode); 
		System.out.println();
		bst.printRightViewUsingQueue(bst.rootNode);*/

		//System.out.println(bst.getHeight(bst.rootNode));
		//System.out.println(bst.getNodeVerticalSum(bst.rootNode));

		/*List<Integer> list = bst.verticalOrder(bst.rootNode);
		printlist(list);*/
		
		/*List<Integer> list2 = bst.verticalOrderTest(bst.rootNode);
		printlist(list2);*/
		
		//System.out.println(bst.minDiff(bst.rootNode, 15));
		
		System.out.println(bst.floor(bst.rootNode, 20));
		System.out.println(bst.floorIterative(bst.rootNode, 20));

	}

	private static void printlist(List<Integer> list) {
		list.forEach(value -> System.out.print(value + ": "));
		System.out.println("**********************");
	}
}
