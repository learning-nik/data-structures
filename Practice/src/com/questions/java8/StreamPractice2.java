package com.questions.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice2 {

	public static void main(String[] args) {

		Student student1 = new Student(10, "MALE");
		Student student2 = new Student(55, "MALE");
		Student student3 = new Student(20, "FEMALE");
		Student student4 = new Student(30, "FEMALE");
		Student student5 = new Student(14, "TRANS");

		List<Student> list = new ArrayList<>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		list.add(student5);

		// count of males and females
		
		long maleCount = list.stream().filter(s -> s.getGender().equals("MALE")).count();
		System.out.println(maleCount);

		// total types of genders
		
		long genderCount = list.stream().map(s -> s.getGender()).distinct().count();
		System.out.println(genderCount);
		
		long genderCount2 =list.stream().collect(Collectors.groupingBy(a->a.getGender())).size();
		System.out.println(genderCount2);

		// Map of Gender and List of students

		Map<String, List<Student>> genderMap = list.stream().collect(Collectors.groupingBy(s -> s.getGender()));
		System.out.println(genderMap);

		// Count of students of each gender
		Map<String, Integer> genderCountMap = genderMap.entrySet().stream()
				.collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().size()));
		System.out.println(genderCountMap);

		// Can be combined and written together
		Map<String, Integer> genderCountMap2 = list.stream().collect(Collectors.groupingBy(s -> s.getGender()))
				.entrySet().stream().collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().size()));

		System.out.println(genderCountMap2);
		
		Map<String, Long> genderCountMap3 =
		list.stream().collect(Collectors.groupingBy(a->a.getGender(),Collectors.counting()));
		
		System.out.println(genderCountMap3);

		// Sort students by age

		//list.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
		//list.stream().sorted((a, b) -> a.getAge().compareTo(b.getAge())).collect(Collectors.toList());
		//list.sort((a,b)->a.getAge().compareTo(b.getAge()));
		//Collections.sort(list,(a,b)->a.getAge().compareTo(b.getAge()));
		System.out.println(list);

		// Sort Hashmap by values 
		Map<String, Integer> studentAge = new HashMap<>();
		studentAge.put("Nik", 30);
		studentAge.put("Pandita", 15);

		Map<String, Integer> sortedStudentAge = studentAge.entrySet().stream()
				.sorted((a, b) -> a.getValue().compareTo(b.getValue()))
				.collect(Collectors.toMap(k -> k.getKey(), 
						v -> v.getValue(), 
						(e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(sortedStudentAge);
	}

}

class Student {

	Integer age;

	String gender;

	public Student(Integer age, String gender) {
		this.age = age;
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", gender=" + gender + "]";
	}

}
