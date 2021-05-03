package ch07.practice02;
import java.util.Scanner;
public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer nam = new Buyer();
		System.out.println(nam.money);
		Scanner scan = new Scanner(System.in);
		nam.money += scan.nextInt();
//		Tv t = new Tv();
//		Computer c = new Computer();
		nam.buy(new Tv());
		nam.buy(new Computer());
		nam.buy(new Tv());
		nam.buy(new Computer());
		nam.buy(new Tv());
		nam.buy(new Computer());
		nam.buy(new Tv());
		nam.buy(new Computer());
		nam.buy(new Tv());
		nam.buy(new Computer());
		System.out.printf("잔액은 %s원 입니다.",nam.money);
		
	}
}

class Product {
	String name;
	int price;
	int bonusPoint;
	
	Product(String name, int price) {
		this.price = price;
		this.bonusPoint = (int)(price/10.0);
		this.name = name;
	}
}

class Tv extends Product {
	static int price = 100;
	Tv() {
		super("Tv", price);
		System.out.printf("Tv 가격은 %s원 입니다. \n", price);
	}
}

class Computer extends Product {
	static int price = 200;
	Computer() {
		super("Computer", price);
		System.out.printf("Computer 가격은 %s원 입니다. \n", price);
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	
	void buy(Product p) {
		if (money<p.price) {
			int c = money - p.price;
			System.out.printf("잔액이 부족합니다 (%s원)", c);
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.printf("잔액: %s원, 포인트: %sP \n", money, bonusPoint);
	}
}