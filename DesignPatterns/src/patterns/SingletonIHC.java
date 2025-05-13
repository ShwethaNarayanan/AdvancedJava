package patterns;

public class SingletonIHC {
	
	// Bill Pugh Singleton — using a static inner holder class
	private SingletonIHC() {}    // private constructor
	
	private static class HolderClass{
		private final static SingletonIHC INSTANCE = new SingletonIHC(); // Holderclass is loaded to JVM lazily. It is loaded when getInstance is called for the first time
	}
	
	public static SingletonIHC getInstance() {
		return HolderClass.INSTANCE;
	}
	

}
