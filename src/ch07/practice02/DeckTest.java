package ch07.practice02;

public class DeckTest {
	public static void main(String[] args) {
		Deck d = new Deck();
		Card c = d.pick(0);
		System.out.println(c);
		
		d.shuffle();
		c = d.pick(0);
		System.out.println(c);
	}
}

class Deck {
	final int CARD_NUM = 52;
	Card[] cardArr = new Card[CARD_NUM];
	
	Deck() {
		int k=0;
		for(int i=Card.KIND_MAX; i>0; i--) {
			for(int j=1; j<=Card.NUM_MAX; j++) {
				cardArr[k] = new Card(i,j);
				k++;
			}
		}
	}
	
	Card pick(int index) {
		return cardArr[index];
	}
	Card pick() {
		int index = (int)(Math.random() * CARD_NUM);
		return this.pick(index);
	}
	
	void shuffle() {
		for(int i=0; i<CARD_NUM; i++) {
			int r = (int)(Math.random() * CARD_NUM);
			Card temp = cardArr[i];
//			Card temp = new Card(); 
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		}
	}
}

class Card {
	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	
	int kind;
	int number;
	
	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	Card() {
		this(CLOVER, 1);
	}
	
	public String toString() {
		String[] kinds = {"","CLOVER","HEART","DIAMOND","SPADE"};
		String numbers = "0123456789XJQK";
		return kinds[this.kind] + ", " + numbers.charAt(this.number);
	}
}
