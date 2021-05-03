package ch07.practice04_ing;

public class DeckTest {
	public static void main(String[] args) {
		Deck d = new Deck();
		Card c = d.pick(0);
		Card c1 = new Card();
		System.out.println(c.kind+ " " + c.number);
		d.pickVoid(0);
		System.out.println(d.pickVoid(0));
		d.pick(0);
		System.out.println(d.pick(0));
		d.shuffle();
		System.out.println(d.pickVoid(0));
		System.out.println(d.pick(0));
	}
}

class Deck {
	static final int CARD_NUM = 52;
	Card arrCard[] = new Card[CARD_NUM];
	
	Deck() {
	int k=0; // 초기화 안함!!
	for(int i=Card.KIND_MAX; i>0; i--) { // Card.KIND_MAX 로 Card. 주소 표기해줘야!!
		for(int j=0; j<Card.NUM_MAX; j++) { // Card.KIND_MAX 는 static
			arrCard[k++] = new Card(i,j+1); 	// Card 는 instance
			}
		}
	}

	Card pick(int index) {
		return arrCard[index];
	}
	Card pick() {
		int index = (int)(Math.random() * CARD_NUM);
		return pick(index);
	}
	
	Card pickVoid(int index) {
		return arrCard[index];
	}
	void pickVoid() {
		int index = (int)(Math.random() * CARD_NUM);
		pickVoid(index);
	}
	
	void shuffle() {
		for(int i=0; i<CARD_NUM; i++) {
			int r = (int)(Math.random() * CARD_NUM);
			Card temp = arrCard[i];
			arrCard[i] = arrCard[r];
			arrCard[r] = temp;
			
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
	
	Card() {
		this(SPADE, 1);
	}
	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789XJQK";
		return kinds[this.kind] + ", " + numbers.charAt(this.number);
	}
}
