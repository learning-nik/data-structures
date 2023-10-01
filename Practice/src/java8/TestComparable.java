package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestComparable {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		list.add(new Employee(4));
		list.add(new Employee(1));
		list.add(new Employee(3));
		list.add(new Employee(2));

		// Method 1 - Using Comparator and Lambda
		Collections.sort(list, (e1, e2) -> {
			return e1.getAge().compareTo(e2.getAge());
		});
		
		// Method 2 - Using Comparator .
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getAge().compareTo(o2.getAge());
			}
		});

		Collections.sort(list, Comparator.comparing(a->a.getAge()));
		
		// Method 3 - using list.sort
		list.sort(Comparator.comparing(Employee::getAge));

		list.sort(Comparator.comparingInt(one -> one.getAge()));
		
		list.sort((e1, e2) -> {
			return e1.getAge().compareTo(e2.getAge());
		});

		// Method 4 - using streams.sorted
		list.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());

		list.stream().sorted(Comparator.comparing(e -> e.getAge())).collect(Collectors.toList());
		
		

		// Method 5 -> If Employee implements Comparable
		//Collections.sort(list); 

		list.forEach(e -> System.out.println(e.getAge()));
	}

}

class Employee {

	private Integer age;

	Employee(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}
}
