package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		Set<Integer> set = list.stream().filter(com -> com % 2 == 0).map(com -> com * 2).collect(Collectors.toSet());

		set.forEach(s -> System.out.println(s));
		
		sortDynamically(list, customPredicate()).forEach(s -> System.out.println(s));

	}

	private static Predicate<Integer> customPredicate() {
		return com -> com % 2 == 0;
	} 

	private static Set<Integer>  sortDynamically(List<Integer> list, Predicate<Integer> filterData) {
		
		return list.stream().filter(filterData).map(com -> com * 2).collect(Collectors.toSet());
	}
	
}


