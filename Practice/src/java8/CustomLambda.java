package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomLambda {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		Filter filter = i -> i % 2 == 0;

		List<Integer> updatedList = list.stream().filter(i -> filter.apply(i)).collect(Collectors.toList());
		updatedList.forEach(System.out::println);

		Filter filter2 = i -> {
			return i % 2 == 0;
		};

		Filter filter3 = (int i) -> {
			return i % 2 == 0;
		};

		DoubleFilter doubleFilter = (x, y) -> (x + y) / 2 == 0;

		DoubleFilter doubleFilter2 = (int x, int y) -> (x + y) / 2 == 0;

		DoubleFilter doubleFilter3 = (int x, int y) -> {
			return (x + y) / 2 == 0;
		};

		Function<Integer, String> integerToString = x -> String.valueOf(x);

		String output = integerToString.apply(10);
		System.out.println(output);

	}

}

interface Filter {

	boolean apply(int i);
}

interface DoubleFilter {

	boolean apply(int i, int y);
}
