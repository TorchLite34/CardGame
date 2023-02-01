import java.util.Random;

public class CardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] list = makeDeck();
		list = shuffle(list);
		Card deck[] = new Card[7];
		
		for(int i = 0; i < deck.length; i++) {
			Card c = new Card(list[i][1], list[i][0]);
			deck[i] = c;
			System.out.println(i+1 + ". " + deck[i].toString());
		}
	}
	
	public static int[][] makeDeck(){
		int[][] cards = new int[52][2];

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
		return cards;
	}
	
	public static int[][] shuffle(int[][] cards) {
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
			return cards;
		}
}
