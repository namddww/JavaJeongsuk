package ch07.practice04_ing;

public class SingletonTest {
	public static void main(String[] args) {
	Singleton s = Singleton.getInstance();
	}

}
final class Singleton {
	private static Singleton s = new Singleton();
	private Singleton() {}
	public static Singleton getInstance() {
		System.out.println("ΩÃ±€≈Ê ø©±‚ø°∏∏");
		return s;
	}
	
}