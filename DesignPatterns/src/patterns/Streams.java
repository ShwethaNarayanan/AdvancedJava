package patterns;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {

		Supplier<String> supplier = new Supplier<String>() {
			@Override
			public String get() {
				return "Welcome to the world of streams!!";
			}
		};

		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String str) {
				System.out.println(str);
			}
		};

		Stream<String> streamStr = Stream.generate(supplier);
		streamStr.forEach(consumer);
		Stream<String> streamStr1 = Stream.generate(() -> "Hello");
		streamStr.forEach(System.out::println);
		
		Stream<Integer> intStream = Stream.of(1, 2,3,4,5,6,7,8,9,10);
		intStream.forEach(System.out::println);
		
		Stream.generate(()->"Hello")
			  .forEach(System.out::println);
		
		Stream.of(1, 2,3,4,5,6,7,8,9,10)
			  .forEach(System.out::println);

	}

}
