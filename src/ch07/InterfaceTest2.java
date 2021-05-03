package ch07;

public class InterfaceTest2 {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
	}
}

interface I {
	public void play();
}

class A {
	void autoPlay(I i) {
		i.play();
	}
}

class B implements I {		// B�� public�� �ƴ����� �޼��尡 public�� ��� B.play()�� �����ؾ�
	public void play() {	// �ϱ� ������ Ŭ���� ���� �������̽� ���� ���������ڰ� ����ȴ�.
		System.out.println("play in B class");
	}
}

class C implements I {
	public void play() {
		System.out.println("play in C class");
	}
}
