package patterns;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Streams3 {
	
	public static void main(String[] args) {
		
		UnaryOperator<Integer> uop = new UnaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer num) {
							return num + 1;
			}
		};
		Stream.iterate(1, uop )
		.limit(20)
		.forEach(num -> System.out.println(num));
	
	
	Stream.iterate(1, num -> {return num + 1;})
			.limit(20)
			.forEach(System.out::println);
		

			
	}
}
