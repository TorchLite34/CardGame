

public class Card{
	
	public Card(){
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
}
