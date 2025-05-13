package patterns;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountChars {

	public static void main(String[] args) {
		String str = "elephant";
		
		Map<Character, Long> charCount = str.chars()
			    .mapToObj(c -> (char) c)
			    .collect(Collectors.groupingBy(c -> c, Collectors.counting()
			    ));
		
		charCount.entrySet()
				.stream()
				.forEach(entry -> {
					System.out.println("Key: " + entry.getKey()+ " " + "Value: " + entry.getValue());
				});
		
		
		// Count the characters in a String
		String str1 = "Hello world";
		
		Map<Character, Long> map = str1.chars()
								   .mapToObj(c -> (char) c)
								   .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
		
		
		
	}

}
