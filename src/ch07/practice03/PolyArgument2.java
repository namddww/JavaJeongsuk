package ch07.practice03;

public class PolyArgument2 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Audio());
		System.out.println();
		b.summary();
	}
}

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		this.bonusPoint = (int)(price/10.0);
	}
}

class Tv extends Product {
	Tv() {
		super(100);
	}
	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		super(50);
	}
	public String toString() {
		return "Audio";
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Product[] item = new Product[10];
	int i = 0;
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "을/를 구입하셨습니다.");
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		String itemList2 = "";
		
		for (int i=0; i<item.length; i++) {
			if(item[i]==null) break;
			sum += item[i].price;
			itemList += item[i] + ", ";
			itemList2 += item[i];
		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
		System.out.println(itemList2 + "test 중 입니다.");
	}
	
	
}