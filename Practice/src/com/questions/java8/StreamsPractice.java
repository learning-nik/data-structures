package com.questions.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsPractice {

	public static void main(String[] args) {

		Product p1 = new Product("Nik-1", "BABY", 100d);
		Product p2 = new Product("Nik-2", "BOY", 500d);
		Product p3 = new Product("Nik-3", "BABY", 600d);
		Product p4 = new Product("Nik-4", "BABY", 600d);

		Set<Product> productSet1 = new HashSet<>();
		productSet1.add(p1);
		productSet1.add(p2);

		Set<Product> productSet2 = new HashSet<>();
		productSet2.add(p3);
		productSet2.add(p4);

		Order order1 = new Order(productSet1, "Order1");
		Order order2 = new Order(productSet2, "Order2");

		List<Order> list = new ArrayList<>();
		list.add(order1);
		list.add(order2);

		//Exercise 1 — Obtain a list of products belongs to category “Baby” with price > 100

		productSet1.stream().filter(a -> a.getCategory().equals("BABY")).filter(a -> a.getPrice() > 100d)
				.collect(Collectors.toSet());

		//Exercise 2 — Obtain a list of orders with products belong to category “Baby”

		list.stream().filter(a -> a.getProducts().stream().anyMatch(p -> p.getCategory().equals("BABY")))
				.collect(Collectors.toList());

		// Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount

		Set<Double> orderSet3 = productSet1.stream().filter(a -> a.getCategory().equals("BABY")).map(a -> a.getPrice())
				//.map(p -> p.withPrice(p.getPrice() * 0.9)
				.collect(Collectors.toSet());

		/*List<Product> result = productSet1
		        .stream()
		        .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
		        .map(p -> p.withPrice(p.getPrice() * 0.9))
		        .collect(Collectors.toList());  */

		// Exercise 5 — Get the cheapest products of “BABY” category

		productSet1.stream().filter(a -> a.getCategory().equals("BABY")).sorted(Comparator.comparing(Product::getPrice))
				.collect(Collectors.toSet());

		productSet1.stream().filter(a -> a.getCategory().equals("BABY"))
				.sorted((a, b) -> a.getPrice().compareTo(b.getPrice())).findFirst();

		//		Exercise 6 — Get the 3 most recent placed order

	}

}

class Customer {

	private Long id;

	private String name;
	private Integer tier;
}

class Order {

	private Long id;
	private String name;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private String status;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Set<Product> getProducts() {
		return products;
	}

	private Customer customer;

	Set<Product> products;

	public Order(Set<Product> products, String name) {
		this.products = products;
		this.name = name;
	}

}

class Product {

	private Long id;

	private String name;
	private String category;
	private Double price;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public Double getPrice() {
		return price;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	private Set<Order> orders;

	public Product(String name, String category, Double price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}
}
