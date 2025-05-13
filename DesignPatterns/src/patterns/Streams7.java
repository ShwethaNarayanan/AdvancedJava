package patterns;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams7 {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Fetch all nums from a list that are greater than 5
		nums.stream().filter(n -> n > 5).forEach(System.out::println);

		// Strings to Upper Case
		List<String> strs = Arrays.asList("apple", "banana", "watermelon");
		strs.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

		// List of List - Flatten it out
		List<List<String>> str_list = Arrays.asList(Arrays.asList("apple", "banana", "watermelon"),
				Arrays.asList("apple", "banana", "watermelon"), Arrays.asList("apple", "banana", "watermelon"));

		str_list.stream().flatMap(Collection::stream).forEach(System.out::println);

		// Remove duplicates from list
		List<Integer> num = Arrays.asList(1, 2, 3, 1, 2, 5, 8, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> distinct = num.stream().distinct().collect(Collectors.toList());
		System.out.println(distinct);

		// Sort List of Strings
		List<String> str = Arrays.asList("lemon", "cantaloupe", "apple", "banana", "watermelon");
		str.stream().sorted().forEach(System.out::println);

		str.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		// Compute the product of all the elements in a list
		long product = nums.stream().reduce(1, (a, b) -> (a * b));
		System.out.println(product);

		// Find the first element in a list that begins with b
		Optional<String> first = str.stream().filter(s -> s.startsWith("b")).findFirst();
		System.out.println(first.get());

		// Max and Min numbers
		Optional<Integer> max = nums.stream().max(Integer::compareTo);
		System.out.println(max.get());

		Optional<Integer> min = nums.stream().min(Integer::compareTo);
		System.out.println(min.get());

		// Convert List of Strings to Array
		String[] arr = str.stream().toArray(String[]::new);

		// Concatenate a list of strings with a delimiter - joining
		String new_str = str.stream().collect(Collectors.joining(", "));
		System.out.println(new_str);

		
		final double D = 1.0/2.0; 
		System.out.println(D);
		
		String s1 = new String ("Test");
		String s2 = new String ("Test");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
String inputString = "Hello, World!";
        
        // Using Stream to count characters
        inputString.chars()   // Convert string to IntStream of characters
        			.mapToObj(c -> (char) c)
                    .forEach(c -> System.out.print((char)c));  // Print each character
        
        Map<Character, Long> charCount = inputString.chars()   // Convert string to IntStream of characters
		.mapToObj(c -> (char) c)
		.collect(Collectors.groupingBy(c -> c , Collectors.counting()));
        charCount.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        System.out.println(); // For new line
	}

}
