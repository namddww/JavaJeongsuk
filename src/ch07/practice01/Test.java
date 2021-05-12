package ch07.practice01;

public class Test {
	public static void main(String args[]) {
		PPP cp = new CCC();
		CCC cc = new CCC();
		System.out.println(cp.number);
		System.out.println(cp.name);
		cp.go();
		System.out.println("-==-");
		QQQ qq = new QQQ();
		System.out.println(qq.qq(cc));
		System.out.println(cc.name);
	}
}

class PPP {
	int number = 1;
	String name = "ppp";
	void go() {
		System.out.println("method PPP");
	}
}

class CCC extends PPP {
	int number = 2;
	String name = "ccc";
	void go() {
		System.out.println("method CCC");
	}
}

class QQQ {
	PPP qq(CCC c) {
		return c;
	}
}

