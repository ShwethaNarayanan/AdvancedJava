package patterns;

public class EagerSingleton {
	
	private EagerSingleton() {}   // private constructor
	
	public static final EagerSingleton instance = new EagerSingleton();
	
	public static final EagerSingleton getInstance() {
		return instance;
	}

}
