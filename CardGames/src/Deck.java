import java.util.Random;

public class Deck extends Card{
	int top = 0;
	int[][] cards = new int[52][2];
	
	public Deck() {//Creates an ordered 2D array of 52 cards
		int s = 1, y = 0;
		for(int i = 0; i < 52; i++) {//iterates 52 times cause 52 cards
		if(i%13 == 0 && i != 0) {/**if the loop reaches the 13th card (king) it returns back to the 1st (ace) 
									and changes to the next suit when the iteration is complete**/
				s++;
				y += 13;
			}
			cards[i][0] = i+1-y; /**setting the first field to the number on the card by,
									adding 1 to the i value since it is always 1 behind and subtracting the 
									multiple of 13 to make it reset back to ace once it finishes the suit**/
			cards[i][1] = s;     //setting the second field to the suit number
		}
	}
	
	public void shuffle() {
		Random rand = new Random();
		int[][] temp = new int[1][2];
			for(int i = 0; i < 52; i++) {
			int location = rand.nextInt(52);
				
			//Record the data in the position being rewritten first
			temp[0][0] = cards[i][0];
			temp[0][1] = cards[i][1];
				
			//Rewrite that data to the data in the random position
			cards[i][0] = cards[location][0];
			cards[i][1] = cards[location][1];
				
			//Rewrite the data in the random position to the stored data
			cards[location][0] = temp[0][0];
			cards[location][1] = temp[0][1];
				
			//Swap complete!!
			}
		}
	
	public void incrementTop() {
		top++;
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < 52; i++) {
			str += i%6 == 0 ? "\n" : "";
			str += String.format("%-26s", (i+1) + ": " + super.getNum(cards[i][0])
			                     + " of " + super.getSuit(cards[i][1]));
		}
		return str;
	}
}
