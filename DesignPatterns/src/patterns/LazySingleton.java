package patterns;

public class LazySingleton {
	
	private LazySingleton() {}   // private constructor
	
	private static volatile LazySingleton instance; 
	
	public final static LazySingleton getInstance() {
		if(instance == null) {
			synchronized(LazySingleton.class){
				if(instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
	

}
