package ch07.practice02;

public class SingletonTest {
	public static void main(String[] args) {
//		Singleton s = new Singleton();
		Singleton s = Singleton.getInstance();
	}
}

final class Singleton {
	private static Singleton s = new Singleton();
	private Singleton() {
		System.out.println("ΩÃ±€≈Ê ¿€µø »Æ¿Œ 04-21");
	}
	
	public static Singleton getInstance() {
		return s;
	}
}
