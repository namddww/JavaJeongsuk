package ch07.prac1;

public class PolyArgumentTest {
	public static void main(String[] args) {
		Tv t = new Tv();
		System.out.println(t);
	}
}

class Product {
	int price;
	int bonusPoint;
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
		this.bonusPoint = bonusPoint;
	}
	Product() {
		this(0);
	}
	public String toString() {
		return price + ", " + bonusPoint;
	}
}

class Tv extends Product{
	int price = 100; // 100������ �ٲ��� ����!
	Tv(int price) {
		this.price = price;
	}
	Tv() {
		super(100);
	}
	
}

class Computer {
	
}

class Buyer {
	
}