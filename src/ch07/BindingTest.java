package ch07;

public class BindingTest {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x = "+p.x);
		System.out.println("p.x = "+p.y);
		p.method();
		System.out.println("p.x = "+c.x);
		System.out.println("p.x = "+c.y);
		c.method();
	}
}

class Parent {
	int x;
	String y;
	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 10;
	String y = "yÃâ·Â";
	void method() {
		System.out.println("Child Method");
	}
}