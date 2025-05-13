package patterns;

import java.util.Arrays;
import java.util.List;

public class Streams9 {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2,3,4,5,6,7,8,9,1,4,5,66,7);
		
		list.stream()
		.distinct()
		.forEach(System.out::println);

	}

}
