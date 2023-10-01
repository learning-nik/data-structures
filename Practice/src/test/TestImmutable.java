package test;

import java.util.ArrayList;
import java.util.List;

public class TestImmutable {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("nikhil");
		
		Immutable object = new Immutable(10, "nikhil", list);
		System.out.println(object);
		list.add("nikhil2");
		System.out.println(object);
		object.getData().add("NIKHIL");
		System.out.println(object);
	}

}
