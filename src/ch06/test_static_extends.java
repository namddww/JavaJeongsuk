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
	static int test = 1;	// ���� 0�� ������ ����: A(�θ�)���� ������ �� static�� ���� �ѹ��� ����
	// �� ��° ������ʹ� ���� ��ü�� �ȵ�! ���ذ��̱� ������!
//	B() {
//		System.out.println(test);
//	}
}