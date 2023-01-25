import java.util.Scanner;

public class Hand extends Card{
	int[][] hand;
	int initcards;
	int cardcount = 0;
	static int[][] played = new int[1][2];

	
	public Hand(int x) {
		hand = new int[52][2];
		this.initcards = x;
	}
	
	public void getHand(Deck d) {
		for(int y = 0; y < initcards; y++) {
			
			hand[y][0] = d.cards[d.top][0];
			hand[y][1] = d.cards[d.top][1];
			cardcount++;
			d.incrementTop();
		}
	}
	
	public void draw(Deck d, int amount) {
		if(d.top + amount <= 52) {
			for(int i = 0; i < amount ; i++) {
				hand[cardcount][0] = d.cards[d.top][0];
				hand[cardcount][1] = d.cards[d.top][1];
				System.out.println("Drawing: " + Card.getNum(hand[cardcount][0]) + " of "  + Card.getSuit(hand[cardcount][1]));
				cardcount++;
				d.incrementTop();
			}
		}else {
			System.out.println("Thats too many cards or the deck is empty");
		}	
	}
	
	public void discard(int card) {
		int i = card-1;
		System.out.println("Discarding: " + Card.getNum(hand[i][0]) + " of "  + Card.getSuit(hand[i][1]));
		while(hand[i][0] != 0) {
			hand[i][0] = hand[i+1][0];
			hand[i][1] = hand[i+1][1];
			i++;
		}
		cardcount--;
	}
	
	public void play(int card) {
		played[0][0] = hand[card-1][0];
		played[0][1] = hand[card-1][1];
		discard(card);
	}
	
	public void give(Hand h, int card) {
		System.out.println("Giving..." + card);
		h.hand[h.cardcount][0] = hand[card-1][0];
		h.hand[h.cardcount][1] = hand[card-1][1];
		System.out.println(h.hand[h.cardcount][0] + " of " + h.hand[h.cardcount][1]);
		discard(card);
	}
	
	public int getNum() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the number: ");
		return keyboard.nextInt();
	}
	
	public String displayTop() {
		return Card.getNum(hand[cardcount-1][0]) + " of "  + Card.getSuit(hand[cardcount-1][1]) + "\n";
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < cardcount; i++) {
			str += (i+1) + ": " + Card.getNum(hand[i][0]) + " of "  + Card.getSuit(hand[i][1]) + "\n";
		}
		return str;
	}
}
