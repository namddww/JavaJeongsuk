package ch07;
import java.util.*;
public class PolyArgumentTest3V {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		Audio audi = new Audio();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audi);
		b.summary();
		System.out.println();
		b.refund(com);
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
	Product() {
	}
}

class Tv extends Product {
	Tv() {super(100);}
	public String toString() {return "Tv";}
}

class Computer extends Product {
	Computer() {super(100);}
	public String toString() {return "Computer";}
	
}

class Audio extends Product {
	Audio() {super(100);}
	public String toString() {return "Audio";}
	
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector();
	
	void buy(Product p) {
		if(money<p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return;}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item.add(p);
		System.out.println(p + "��/�� �����ϼ̽��ϴ�.");
	}
	
	void refund(Product p) {
		if(item.remove(p)) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "��/�� ��ǰ�ϼ̽��ϴ�.");
	} else {
		System.out.println("�����Ͻ� ��ǰ �� �ش� ��ǰ�� �����ϴ�.");
	}
}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		if(item.isEmpty()) {
			System.out.println("�����Ͻ� ��ǰ�� �����ϴ�.");
			return;
		}
		
		for(int i=0; i<item.size(); i++) {
			Product p = (Product)item.get(i);
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}
		System.out.println("�����Ͻ� ��ǰ�� �ѱݾ���" + sum + "�����Դϴ�.");
		System.out.println("�����Ͻ� ��ǰ��" + itemList + "�Դϴ�.");
	}
}
