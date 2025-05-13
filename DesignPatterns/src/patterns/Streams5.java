package patterns;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Streams5 {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("alice","bob", "cat", "john");
		
		//Convert all the names to uppercase - Map
		names.stream()
			 .map(name -> name.toUpperCase())
			 .forEach(System.out::println);
		
		//Sort the elements 
		names.stream()
			.sorted()
			.forEach(System.out::println);
		
		//Sort elements in reverse order
		names.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println);
		
		//Sort elements based on the length of the string
		names.stream()
		.sorted()
		.forEach(System.out::println);
		
		
		
//		// Terminal operation - Performs a reduction on the elements of this stream, using the provided identity value 
//		// and an associative accumulation function, and returns the reduced value. 
//		List<Integer> iList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		System.out.println(iList.stream()
//			 .reduce(0, (a , b) -> a + b));
//			 
//		
//		//FlatMap
//		List<List<String>> listOfList = Arrays.asList(
//												Arrays.asList("a","b", "c"),
//												Arrays.asList("d","e", "f"),
//												Arrays.asList("g","h", "i"));
//		
//		listOfList.stream()
//				.flatMap(list -> list.stream())
//				.map(s -> s.toUpperCase())
//				.forEach(System.out::println);
//		
//		listOfList.stream()
//		.flatMap(Collection::stream)
//		.map(String::toUpperCase)
//		.forEach(System.out::println);
	}

}
