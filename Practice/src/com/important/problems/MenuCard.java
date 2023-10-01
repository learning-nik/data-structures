package com.important.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/discuss/interview-experience/1380566/Swiggy-or-SDE-III-or-Bengaluru-or-Jul-2021-Reject
public class MenuCard {
	/*	
	Veg
		Paneer
			Manchurian
				Full
				Half
			Chilli
				Full
				Half
		Rice
			Full
			Half
	Non Veg
		Chicken
			Kebab
			Lollipop
		Fish
	Ice Creams
		Vanila
		Mango
		Strawberry
	*/

	public static void main(String[] args) {

		List<String> manchurianList = new ArrayList<>();
		manchurianList.add("HALF");
		manchurianList.add("FULL");

		List<String> chilliList = new ArrayList<>();
		chilliList.add("HALF");
		chilliList.add("FULL");

		List<List<String>> paneerList = new ArrayList<>();
		paneerList.add(manchurianList);
		paneerList.add(chilliList);

		List<String> riceList = new ArrayList<>();
		riceList.add("HALF");
		riceList.add("FULL");

		List<List<List<String>>> vegList = new ArrayList<>();
		vegList.add(paneerList);

		//		vegList.add(null)

		// ------------------------------------------------------------//

		Item half = new Item("HALF", null);
		Item full = new Item("FULL", null);

		List<Item> halfFullList = new ArrayList<>();
		halfFullList.add(half);
		halfFullList.add(full);

		Item manchurian = new Item("Manchurian", halfFullList);
		Item chilli = new Item("Chilli", halfFullList);

		List<Item> paneerItems = new ArrayList<>();
		paneerItems.add(manchurian);
		paneerItems.add(chilli);

		Item panner = new Item("Paneer", paneerItems);
		Item rice = new Item("Rice", halfFullList);

		List<Item> vegItemList = new ArrayList<>();
		vegItemList.add(panner);
		vegItemList.add(rice);

		Item vegItems = new Item("VEG", vegItemList);

		// Non Veg

		/*Non Veg
		Chicken
			Kebab
			Lollipop
		Fish*/

		Item kabab = new Item("Kabab", null);
		Item lollipop = new Item("Lollipop", null);

		List<Item> chickenList = new ArrayList<>();
		chickenList.add(kabab);
		chickenList.add(lollipop);

		Item chickItem = new Item("Chicken", chickenList);
		Item fish = new Item("Fish", null);

		List<Item> nonVegList = new ArrayList<>();
		nonVegList.add(chickItem);
		nonVegList.add(fish);

		Item nonVegItems = new Item("NON-VEG", nonVegList);

		Map<String, Item> menuCard = new HashMap<>();
		menuCard.put("VEG", vegItems);
		menuCard.put("NON-VEG", nonVegItems);

		// To print the menu card
		// DFS for a tree with n children 

		printTree(vegItems);
		//System.out.println(maxDepth(vegItems));

	}

	// DFS
	private static void printTree(Item vegItem) {

		if (vegItem == null) {
			return;
		}

		System.out.print(vegItem.getName() + "::");

		List<Item> list = vegItem.getItemList();

		if (list != null) {
			for (Item item : list) {
				printTree(item);
			}
		}

	}
	
	  public static int maxDepth(Item root) {

	        if(root ==null){
	            return 0;
	        }
	        
	        if(root.getItemList() == null) {
	        	return 1;
	        }

	        int maxHeight =0;
	        for(Item child : root.getItemList()){
	           int currentHeight = maxDepth(child);
	           maxHeight = Math.max(maxHeight, currentHeight);
	        }
	        
	        return 1 + maxHeight;
	        
	    }

	static class Item {

		private String name;

		private List<Item> itemList;

		public Item(String name, List<Item> itemList) {
			super();
			this.name = name;
			this.itemList = itemList;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Item> getItemList() {
			return itemList;
		}

		public void setItemList(List<Item> itemList) {
			this.itemList = itemList;
		}

	}

}
