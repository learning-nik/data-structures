package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(10, "nikhil");
		map.put(1, "pandita");
		map.put(7, "nikhil");
		map.put(9, "akhil");

		List<Map.Entry<Integer, String>> list = new ArrayList<>();

		list.addAll(map.entrySet());

		list.sort((a, b) -> {
			if (a.getValue().compareTo(b.getValue()) == 0) {
				return a.getKey().compareTo(b.getKey());
			} else {
				return a.getValue().compareTo(b.getValue());
			}

		});

		list.forEach(a -> System.out.println(a));
		
	}

}
