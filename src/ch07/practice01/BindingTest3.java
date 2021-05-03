package ch07.practice01;

public class BindingTest3 {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println(p.x);
		System.out.println("---------------");
		System.out.println(c.x);
		System.out.println("---------------");	
		p.method();
		System.out.println("---------------");
		c.method();
		
	}
}

class Parent {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;
	void method() {
		System.out.println("x="+x);
		System.out.println("super.x="+super.x);
		System.out.println("this.x="+this.x);
	}
}