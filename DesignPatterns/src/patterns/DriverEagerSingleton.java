package patterns;

public class DriverEagerSingleton {

	public static void main(String[] args) {
		EagerSingleton es1 = EagerSingleton.getInstance();
		EagerSingleton es2 = EagerSingleton.getInstance();
		EagerSingleton es3 = EagerSingleton.getInstance();
		
		System.out.println(es1);
		System.out.println(es2);
		System.out.println(es3);
		System.out.println(es1 == es2);
		System.out.println(es1 == es3);


	}

}
