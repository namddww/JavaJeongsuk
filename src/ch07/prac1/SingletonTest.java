package ch07.prac1;

public class SingletonTest {
	public static void main(String[] args) {
	Singleton s = Singleton.getInstance();
	System.out.println();
	s.grap();
	System.out.println();
	System.out.println(s.wt);
	}
}

class Singleton {
	private static Singleton s = new Singleton();
	private Singleton() {
	System.out.println("�����");
	}
	public static Singleton getInstance() {
		return s;
	}
	void grap() {
		System.out.println("������ �״´� ^^");
	}
	String wt = "...";
}
