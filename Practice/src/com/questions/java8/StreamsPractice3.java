package com.questions.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsPractice3 {

	class Employee {
		int id;

		String name;

		int age;

		String gender;

		String department;

		int yearOfJoining;

		double salary;

		public Employee(int id, String name, int age, String gender, String department, int yearOfJoining,
				double salary) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.department = department;
			this.yearOfJoining = yearOfJoining;
			this.salary = salary;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public String getGender() {
			return gender;
		}

		public String getDepartment() {
			return department;
		}

		public int getYearOfJoining() {
			return yearOfJoining;
		}

		public double getSalary() {
			return salary;
		}

		@Override
		public String toString() {
			return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
					+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
		}
	}

	public static void main(String[] args) {

		//https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/

		new StreamsPractice3().test();

	}

	private void test() {
		List<Employee> list = new ArrayList<Employee>();

		buildEmployees(list);

		//----------------------------------------------------------------------------------------

		// Query 3.1 : How many male and female employees are there in the organization?

		long females = list.stream().filter(a -> a.getGender().equals("Female")).count();

		System.out.println(females);

		long males = list.stream().filter(a -> a.getGender().equals("Male")).count();

		System.out.println(males);

		Map<String, Long> genderMap = list.stream()
				.collect(Collectors.groupingBy(a -> a.getGender(), Collectors.counting()));

		System.out.println(genderMap);

		//-------------------------------------------------------------------------------------------

		//		Query 3.2 : Print the name of all departments in the organization?

		List<String> departmentList = list.stream().map(a -> a.getDepartment()).distinct().collect(Collectors.toList());

		System.out.println(departmentList);

		//-------------------------------------------------------------------------------------------
		//		Query 3.3 : What is the average age of male and female employees?

		Map<String, Double> averageAge = list.stream()
				.collect(Collectors.groupingBy(a -> a.getGender(), Collectors.averagingDouble(a -> a.getAge())));
		System.out.println(averageAge);

		//-------------------------------------------------------------------------------------------

		// Query 3.4 : Get the details of highest paid employee in the organization?

		list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());

		Employee highestPaid = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.findFirst().get();
		System.out.println(highestPaid);

		Employee highestPaid2 = list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(a -> a.getSalary())))
				.get();

		System.out.println(highestPaid2);

		Employee highestPaid3 = list.stream().max(Comparator.comparingDouble(a -> a.getSalary())).get();
		System.out.println(highestPaid3);

		//-------------------------------------------------------------------------------------------
		//Query 3.5 : Get the names of all employees who have joined after 2015?

		//-------------------------------------------------------------------------------------------

		//		Query 3.6 : Count the number of employees in each department?

		Map<String, Long> departEmployes = list.stream()
				.collect(Collectors.groupingBy(a -> a.getDepartment(), Collectors.counting()));
		System.out.println(departEmployes);

		//-------------------------------------------------------------------------------------------

		//		Query 3.8 : Get the details of youngest male employee in the product development department?

		Employee employee = list.stream().filter(a -> a.getDepartment().equals("Product Development"))
				.min(Comparator.comparingInt(Employee::getAge)).get();

		System.out.println(employee);

	}

	private void buildEmployees(List<Employee> employeeList) {
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	}

}
