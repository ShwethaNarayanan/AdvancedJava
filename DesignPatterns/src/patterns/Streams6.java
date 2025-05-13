package patterns;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Streams6 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2,3,4,5,6,7,8);
		
		//Find the sum of all the elements in a List
		long sum = list.stream()
						.reduce(0, (a,b) -> a + b);
		System.out.println(sum);
		
		//Find the max element in a list
		Optional<Integer> max_num = list.stream()
						   .max(Comparator.naturalOrder());		
		System.out.println(max_num.get());
		
		//Count the number of strings that start with a letter
		List<String> strL = Arrays.asList("Minu", "Anu", "Sinu", "Chinnu", "Sonu");
		strL.stream()
			.filter(str -> (str.charAt(0) == 'S'))
			.forEach(System.out::println);
		
		//Convert a list of string to uppercase
		strL.stream()
			.map(str -> str.toUpperCase())
			.forEach(System.out::println);
		
		

	}

}
