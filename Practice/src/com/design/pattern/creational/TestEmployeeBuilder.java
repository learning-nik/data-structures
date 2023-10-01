package com.design.pattern.creational;

import com.design.pattern.creational.Employee.EmployeeBuilder;

public class TestEmployeeBuilder {

	public static void main(String[] args) {

		EmployeeBuilder builder = new EmployeeBuilder();
		builder.addEmployeeId(1);
		builder.addEmployeeName("Nikhil");

		Employee emp = builder.build();
		System.out.println(emp.getId());
		System.out.println(emp.getName());
	}

}

class Employee {

	private int id;

	private String name;

	private Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	static class EmployeeBuilder {

		private int id;

		private String name;

		public void addEmployeeId(int id) {
			this.id = id;
		}

		public void addEmployeeName(String name) {
			this.name = name;
		}

		public Employee build() {

			Employee emp = new Employee();
			emp.id = this.id;
			emp.name = this.name;
			return emp;

		}
	}
}