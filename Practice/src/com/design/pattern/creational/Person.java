package com.design.pattern.creational;

import java.util.UUID;

public class Person {

	private String name;
	private String details;
	private String id;

	private Person() {}

	public static class PersonBuilder {

		private String name;
		private String details;

		PersonBuilder addName(String name) {
			this.name = name;
			return this;
		}

		PersonBuilder addDetails(String details) {
			this.details = details;
			return this;
		}

		public Person build() {
			Person person = new Person();
			person.details = this.details;
			person.name = this.name;
			person.id = UUID.randomUUID().toString();

			return person;
		}

	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", details=" + details + ", id=" + id + "]";
	}

}
