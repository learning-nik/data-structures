package test;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationTest {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		
	/*	for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			if (list.get(i).equals(3))
				list.remove(list.get(i));
		}*/
		
		/*for(Integer listMember: list) {
			System.out.println(listMember);
			if (listMember.equals(3))
				list.remove(listMember);
		}*/

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals(3))
				it.remove();
				//list.add(11);
		}
		
		

	}
}
