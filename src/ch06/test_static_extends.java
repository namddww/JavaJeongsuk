package ch06;

public class test_static_extends {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		A c = new B();
		System.out.println(a.test);
		System.out.println(b.test);
		System.out.println(c.test);
	}
}

class A {
	static int test = 0;
//	A() {
//		System.out.println(test);
//	}
}

class B extends A {
	static {};
	static int test = 1;	// 값이 0이 나오는 이유: A(부모)부터 실행할 때 static은 최초 한번만 실행
	// 두 번째 실행부터는 실행 자체가 안됨! 기준값이기 때문에!
//	B() {
//		System.out.println(test);
//	}
}