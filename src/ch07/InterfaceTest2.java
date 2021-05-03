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

class B implements I {		// B는 public이 아니지만 메서드가 public일 경우 B.play()로 접근해야
	public void play() {	// 하기 때문에 클래스 따로 인터페이스 따로 접근제한자가 적용된다.
		System.out.println("play in B class");
	}
}

class C implements I {
	public void play() {
		System.out.println("play in C class");
	}
}
