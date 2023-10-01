package test;

import java.util.ArrayList;
import java.util.List;

/**
The class must be declared as final so that child classes can’t be created.

Data members in the class must be declared private so that direct access is not allowed.

Data members in the class must be declared as final so that we can’t change the value of it after object creation.

A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.

Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)

*/
public final class Immutable {

	private final int id;
	private final String name;
	private final List<String> data;

	public Immutable(int id, String name, List<String> data) {
		this.id = id;
		this.name = name;
		
		//deep copying 
		this.data=new ArrayList<>(data);
	}
	
	@Override
	public String toString() {
		return "Immutable [id=" + id + ", name=" + name + ", data=" + data + "]";
	}

	public List<String> getData() {
		//ArrayList<String> list = (ArrayList) data;
		return new ArrayList<>(data);
		
	}
	
	
}
