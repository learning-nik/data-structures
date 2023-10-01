package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class TestBiConsumer {

	public static void main(String[] args) {
		
		// create a map of type BiConsumer.
		Map<String, BiConsumer<Data,String>> map = new HashMap<>();
		map.put("Nikhil", Data::setName);
		map.put("Pandita", (data,name)->data.setName(name));
		
		// List containing a BiConsumer
		List<BiConsumer<Data,String>> list = new ArrayList<>();
		list.add((data,value)->data.setName(value));
		list.add(Data::setName);
		
		Data data = new Data();
		
		//  
		for(Map.Entry<String, BiConsumer<Data, String>>  entry: map.entrySet()) {
			entry.getValue().accept(data, "Nik");
		}
		
		
		
		
		
		
		
		
		// Calling a BiConsumer
		/*
		 * test1((data,value)->{ data.setName(value); });
		 */

		
	}

	static class Data {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static void test1(BiConsumer<Data, String> consumer) {
		
	}

}
