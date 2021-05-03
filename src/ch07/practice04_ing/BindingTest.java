package ch07.practice04_ing;

public class BindingTest {
	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		Parent pc = new Child();
//		Child cp = (Child)p;
		
		System.out.println(p.x);
		p.method();
		p.method2();
		System.out.println("-----");

		System.out.println(c.x);
		c.method();
		c.method2();
		System.out.println("-----");
		
		System.out.println(pc.x);
		pc.method();
		pc.method2();
//		System.out.println(cp.x);
//		cp.method();
	}
}

class Parent {
	int x = 100;
	void method() {
		System.out.println("Parent");
	}
	int method2() {
		x = 3100;
		System.out.println(x + " Parent");
		return x;
	}
}

class Child extends Parent {
	int x = 200;
	void method() {
		System.out.println("Child");
	}
	int method2() {
		x = 3200;
		System.out.println(x + " Child");
		return x;
	}
	
}
