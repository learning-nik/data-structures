package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestFunction {

	private static final Function<String, Integer> STRING_TO_INT= (String input)->{
		return Integer.parseInt(input);
	};
	
	public static void main(String[] args) {
		
		int output=STRING_TO_INT.apply("10");
		System.out.println(output);
		
		List<String> list = new ArrayList<String>();
		list.add("1");
	//	list.stream().forEach((1)->"");
	}
}
