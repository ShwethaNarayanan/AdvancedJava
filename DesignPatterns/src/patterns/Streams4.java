package patterns;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams4 {
	
	public static void main(String[] args) {
		
		//Creating streams from primitive array
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		Arrays.stream(arr)
		.forEach(System.out::println);
		
		
		//Creating stream from object array
		Integer[] intObjarr = {1,2,3,4,5,6,7,8,9,10};
		Stream.of(intObjarr)
		.forEach(System.out::println);
		
		//Creating streams from Collections
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		list.stream()
			.forEach(System.out::println);
		
		
	}

}
