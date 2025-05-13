package patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverSingleton {
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(() -> SingletonClass.getInstance());
		executor.execute(() -> SingletonClass.getInstance());
		executor.execute(() -> SingletonClass.getInstance());
		executor.execute(() -> SingletonClass.getInstance());
		executor.execute(() -> SingletonClass.getInstance());
		executor.execute(() -> SingletonClass.getInstance());
		executor.execute(() -> SingletonClass.getInstance());
		
		SingletonClass originalS = SingletonClass.getInstance();
		try {
			SingletonClass cloneS = (SingletonClass) originalS.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
