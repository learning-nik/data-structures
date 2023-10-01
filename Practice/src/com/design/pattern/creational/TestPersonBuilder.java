package com.design.pattern.creational;

import com.design.pattern.creational.Person.PersonBuilder;

public class TestPersonBuilder {
	
	public static void main(String[] args) {
		//new Person.PersonBuilder()
		PersonBuilder personBuilder = new Person.PersonBuilder();
		personBuilder.addDetails("OBJECT 1");
		personBuilder.addName("OBJECT NAME 1");
		Person person1 = personBuilder.build();
		
		PersonBuilder personBuilder2 = new Person.PersonBuilder();
		personBuilder2.addDetails("OBJECT 2");
		personBuilder2.addName("OBJECT NAME 2");
		Person person2 = personBuilder2.build();
		
		System.out.println(person1);
		System.out.println(person2);
	}

}
