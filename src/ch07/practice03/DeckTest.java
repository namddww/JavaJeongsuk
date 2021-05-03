package ch07.practice03;

public class DeckTest {
	public static void main(String[] args) {
		Deck d = new Deck();
		Card c = d.pick(0);
		System.out.println(c);
		System.out.println(d.pick());
		
		d.shuffle();
		Card c1 = d.pick(0);
//		c1=c;
		System.out.println(c1);
		
		int start=0;
		while(true) {
			start++;
			d.shuffle();
			c1 = d.pick(0);
			System.out.print(start+ "¹øÂ°: ");
			System.out.printf("%s [vs] %s \n", c, c1);
			if (c == c1) {
				break;
			}
		}
		
	}
}

class Deck {
	static final int CARD_NUM = 52;
	Card cardArr[] = new Card[CARD_NUM];
	
	Deck() {
		int i = 0;
		for(int j=Card.KIND_MAX; j>0; j--) {
			for(int k=0; k<Card.NUM_MAX; k++) {
				cardArr[i++] = new Card(j, k+1);
			}
		}
	}
	
	Card pick() {
		int index = (int)(Math.random() * CARD_NUM);
		return pick(index);
	}
	
	Card pick(int index) {
		return cardArr[index];
	}
	
	void shuffle() {
		for (int i=0; i<CARD_NUM; i++) {
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
		this(SPADE, 1);
	}
	
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789XJQK";
		return kinds[this.kind] + ", " + numbers.charAt(this.number);
	}
	
}
