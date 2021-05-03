package ch07.practice01;

final class Singleton{
	private static Singleton s = new Singleton();
	private Singleton() {
		System.out.println("ΩÃ±€≈Ê ¿€µø »Æ¿Œ");
	}
	
	public static Singleton getInstance() {
		if (s==null)
			s = new Singleton();
		return s;
	}
}

class SingletonTest{
	public static void main(String[] args) {
//		Singleton s1 = new Singleton();
		Singleton s = Singleton.getInstance();
	}
}