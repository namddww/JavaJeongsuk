package ch07.prac1;

public class DeckTest {
	public static void main(String[] args) {
	Deck d = new Deck();
	System.out.println(d.pick(0));
	d.pick();
	System.out.println(d.pick());
	System.out.println();
	System.out.println(d.pick(0));
	d.shuffle();
	System.out.println(d.pick(0));
	}
}

class Deck {
	static final int CARD_NUM = 52;
	Card[] cardArr = new Card[CARD_NUM];
	Deck() {
		
		int k = 0;
		for(int i=Card.KIND_MAX; i>0; i--) {
			for(int j=1; j<=Card.NUM_MAX; j++) {
				cardArr[k++] =new Card(i,j);
			}
		}
	}
	Card pick(int index) {		
		return cardArr[index];
	}
	Card pick() {
		int r = (int)(Math.random() * CARD_NUM);
		return pick(r);
	}
	
	void shuffle() {
		for(int i=0; i<CARD_NUM; i++) {
			int r = (int)(Math.random() * CARD_NUM);
			Card temp = cardArr[i];
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
		this(SPADE,1);
	}
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789XJQK";
		return "종류: " + kinds[this.kind] + ", 넘버: " + numbers.charAt(this.number);
	}
}
