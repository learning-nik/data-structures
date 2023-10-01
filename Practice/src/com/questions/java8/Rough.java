package com.questions.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Rough {
	

	public static void main(String[] args) {
		
		//int arr[] = { 0, 0, 0, 1, 1 };
		
		//List<String> songs=Arrays.asList("humble");
		
		List<String> list1=Arrays.asList("Jammu","Punjab");
		List<String> list2=Arrays.asList("Kerala","Karnataka");
		List<String> list3=Arrays.asList("MP","UP");
		List<String> list4=Arrays.asList("Bengal","Assam");
		
		List<List<String>> list = new ArrayList<>();
		list.add(list1);list.add(list2);list.add(list3);list.add(list4);
		
		System.out.println(list);
		
		List<String> flatedList=list.stream().flatMap(a->a.stream()).collect(Collectors.toList());
		
		System.out.println(flatedList);
		
		
		
		
		//Arrays.asList(arr[0]).stream().filter(a->a==0).collect(Collectors.toList());
		
		//Arrays.stream(arr).filter(a->a==0).collect(null, null, null)
		
		//List<Integer> list = new ArrayList<>();
		/*		for(int i=0;i<arr.length;i++) {
					list.add(arr[i]);
				}
		*/		
		//list.stream().filter(a->a==0).collect(Collectors.toList());
		
		//Arrays.stream(arr).filter(e->e==0).collect(null, null, null);
		//List<Integer> list=Arrays.asList(arr);
		
		//Arrays.asList(arr).stream().filter(b -> b == 0).collect(Collectors.toList());

		//String s ="+nik123#";
		
		/*for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c) || Character.isLetter(c)) {
				System.out.println(c);
			}
		}*/
		
		

		/*List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);list.add(3);list.add(4);
		
		List<Integer> newList=list.stream().map(a->a*2).collect(Collectors.toList());
		
		newList.forEach(a->System.out.print(a+" ,"));*/
		
		/*List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1,2));
		list.add(Arrays.asList(3,4));
		list.add(Arrays.asList(5,6));
		
		List<Integer> newList=list.stream().flatMap(a->a.stream()).collect(Collectors.toList());
		
		newList.forEach(a->System.out.print(a+" ,"));*/
		
		//System.out.println(list.stream().filter(e -> e % 2 == 0).collect(Collectors.summingInt(Integer::intValue)));
		
		//System.out.println(list.stream().filter(e -> e % 2 == 0).collect(Collectors.summingInt(a->a)));
		
		//System.out.println(new Rough().hashCode());
		//System.out.println(new Rough().hashCode());
		
		/*Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 20);
		
		System.out.println(map.getOrDefault(2, 0)+1);*/
		
		Map<TreeKey,Integer> map = new TreeMap<>();
		// map.put(null, 30); Runtime exception
		//map.put(1, null); // allowed
		//map.put(new TreeKey(), 1); // Runtime error
		
		
	}
}

/*class TreeKey implements Comparable<Integer>{

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}*/

class TreeKey {
	
}

