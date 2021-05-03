package ch07.practice01;

public class PolyArgumentTest {
	public static void main(String[] args) {
	BuyerNam n = new BuyerNam();
	Tv t = new Tv();
	Computer c = new Computer();
	
	n.buy(t);
	n.buy(c);
	
	System.out.println(n);
	}
}

class Product {
	int money;
	int bonusPoint;
	int price;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10);
	}
}

class Tv extends Product {
	static int price = 100;
	Tv() {
		super(price);
		System.out.printf("가격은 %s원입니다. \n", price);
	}
}
class Computer extends Product {
	static int price = 200;
	Computer() {
		super(price);
		System.out.printf("가격은 %s원입니다. \n", price);
	}
}

class BuyerNam {
	int money = 1000;
	int bonusPoint = 0;
	
	void buy(Product p) {
		money -= p.price;
		bonusPoint += p.bonusPoint;
		}
	public String toString() {
		return "잔액:" + money + "원 ," + bonusPoint+"P";
	}
	
}