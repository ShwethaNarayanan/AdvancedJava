package patterns;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams2 {
	
	public static void main(String[] args) {
		
//		Predicate<Integer> predicate = new Predicate<>() {
//			@Override
//			public boolean test(Integer n) {
//				return n > 5;
//			}
//			
//		};
		
		Function<Integer, String> func = new Function<>(){
			public String apply(Integer num) {
				switch (num) {
				case 6 : return "Six";
				case 7 : return "Seven";
				case 8 : return "Eight";
				case 9 : return "Nine";
				case 10 : return "Ten";
				}
				return "Not Valid";
			}
			};
			

		Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };		
		Arrays.stream(numbers)
			  .peek(num -> System.out.println("Peek :" + num))
			  .filter(num -> (num > 5))
			  .map(func)
			  .forEach(System.out::println);
		
		List<String> list = Arrays.stream(numbers)
		  .filter(num -> (num > 5))
		  .map(num -> { switch (num) {
			case 6 : return "Six";
			case 7 : return "Seven";
			case 8 : return "Eight";
			case 9 : return "Nine";
			case 10 : return "Ten";
			}
			return "Not Valid"; })
		  .collect(Collectors.toList());
		System.out.println(list);
		
		
		long count = Arrays.stream(numbers)
				  .filter(num -> (num > 5))
				  .map(num -> { switch (num) {
					case 6 : return "Six";
					case 7 : return "Seven";
					case 8 : return "Eight";
					case 9 : return "Nine";
					case 10 : return "Ten";
					}
					return "Not Valid"; })
				  .count();
		System.out.println(count);

	
	
	//Square of every number that is less than 8
	
     Arrays.stream(numbers)
     		.filter(num -> num < 8)
     		.map(num -> num * num)
     		.forEach(System.out::println);
     
     Arrays.stream(numbers)
		.takeWhile(num -> num < 8)
		.map(num -> num * num)
		.forEach(System.out::println);
	
	
}
}
