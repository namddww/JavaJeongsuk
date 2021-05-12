package ch07.practice01;

public class Prdt {
	public static void main(String arge[]) {
		
	}	
}

class Product {
	int price = 100;
}

class Tv extends Product {
	int price = 200;
}

class Video extends Product {
	int price = 300;
}

class Buyer {
	int price;
	int buy(Product p) {
		return price;
	};
}