package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice4 {

	/*	Given two entity
		Customer:
		String name;
		String email;
		List allAddress;
	
		Address:
		String city;
		String pincode;
	
		Use stream api to fetch all cities from all users(not necessarily distinct)*/

	public static void main(String[] args) {

		new StreamPractice4().test();
	}

	void test() {
		Address nikAddress1 = new Address("Jammu", "180007");
		Address nikAddress2 = new Address("Bangalore", "560037");

		Address komalAddress1 = new Address("Jammu", "180007");
		Address komalAddress2 = new Address("Gwalior", "47034");

		Customer customerNik = new Customer("NIK", "nikhil09ec060@gmail.com", Arrays.asList(nikAddress1, nikAddress2));

		Customer customerKomal = new Customer("KOMAL", "komal@gmail.com", Arrays.asList(komalAddress1, komalAddress2));

		List<Customer> customers = new ArrayList<>();
		customers.add(customerKomal);
		customers.add(customerNik);

		//customers.stream().forEach(a->a.allAddress.stream().collect(Collectors.toList()));

		List<Address> addressList = customers.stream().flatMap(a -> a.allAddress.stream()).collect(Collectors.toList());

		List<String> cityList = customers.stream().flatMap(a -> a.allAddress.stream().map(p -> p.city))
				.collect(Collectors.toList());

		Map<String, List<Address>> map = customers.stream().collect(Collectors.toMap(a -> a.email, a -> a.allAddress));

		System.out.println(addressList);

		System.out.println(cityList);

		System.out.println(map);

	}

	class Customer {
		String name;
		String email;
		List<Address> allAddress;

		public Customer(String name, String email, List<Address> allAddress) {
			super();
			this.name = name;
			this.email = email;
			this.allAddress = allAddress;
		}

	}

	class Address {
		String city;
		String pincode;

		public Address(String city, String pincode) {
			super();
			this.city = city;
			this.pincode = pincode;
		}

		@Override
		public String toString() {
			return "Address [city=" + city + ", pincode=" + pincode + "]";
		}

	}

}
