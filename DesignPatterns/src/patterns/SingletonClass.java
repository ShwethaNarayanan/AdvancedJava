package patterns;

public class SingletonClass implements Cloneable{

	// Variable to store the created instance of the class
	// Volatile - To read the instance from the RAM rather than the cache, so that
	// multiple instances are not created. This helps in a multi-threaded
	// environment.
	// The moment any thread has created the first instance of the class
	// this value will get updated.
	// Double null checking is done, to make sure that two or more threads that have
	// entered the getInstance method are not creating 2 instances. Defining the
	// singletonInstance variable as volatile ensures that the moment any thread
	// creates
	// an instance, it will get updated as it directly read from RAM instead of
	// cache.
	private static volatile SingletonClass singletonInstance = null;

	// Private Constructor so that the class cannot be instantiated from outside
	private SingletonClass() {
	}

	public static SingletonClass getInstance() {
		if (singletonInstance == null) {  // Instead of defining the entire method as synchronized, we define a synchronized block to save threads waiting time
			synchronized (SingletonClass.class) {
				if (singletonInstance == null) {
					singletonInstance = new SingletonClass();
					System.out.println("Singleton Class instantiated " + singletonInstance);
				}
			}
		}
		System.out.println("Singleton Class instance : " + singletonInstance);
		return singletonInstance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return singletonInstance;
	}

}
