import java.util.Random;

public class Card {
	String suit;
	String number;
	
	public Card() {
		Random rand = new Random();
		suit = getSuit(rand.nextInt(4)+1);
		number = getNum(rand.nextInt(13)+1);
	}
	
	public Card(int suit, int num) {
		this.suit = getSuit(suit);
		this.number = getNum(num);
	}
	
	public Card(String suit, String num) {
		this.suit = suit;
		this.number = num;
	}
	
	public static String getSuit(int suit) {
		switch (suit) {
		case 1:
			return"Hearts";
		case 2:
			return "Clubs";
		case 3:
			return "Spades";
		case 4:
			return "Diamonds";
		default:
			return ""+suit;
		}
	}
	
	public static String getNum(int number) {
		switch (number) {
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "king";
		case 1:
			return "Ace";
		default:
			return ""+number;
		}
	}
	public String toString() {
		return number + " of " + suit;
	}
}
