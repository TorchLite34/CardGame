
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card. 
 * To be used as starting code in Exercise
 *
 * @author Jordan
 * @author Jordan Ing, February 1st 2023
 */
public class CardTest {
    
    public static void main(String[] args) {
        
		int[][] list = makeDeck();
		list = shuffle(list);
		Card deck[] = new Card[7];
		
		for(int i = 0; i < deck.length; i++) {
			Card c = new Card(list[i][1], list[i][0]);
			deck[i] = c;
			System.out.println(i+1 + ". " + deck[i].toString());
		}
		
		boolean gameon = true;
		while(gameon == true){
			int[] temp = getInput();
			Card tempCard = new Card(temp[1], temp[0]);
			for(int i = 0; i < deck.length; i++) {
				if(deck[i].toString().equals(tempCard.toString())) {
					gameon = false;
					break;
				}
			}
			if(gameon == true) {
				System.out.println("No match!!! Please try again!!!");
			}
		}
		printInfo();
	}
    
	


        

        // insert code to ask the user for Card value and suit, create their card
        // and search the hand here. 
        // Hint: You can ask for values 1 to 10, and then
        //       11 for jack, 12 for queen, etc. (remember arrays are 0-based though)
        //       1 for Hearts, 2 for Diamonds, etc. (remember arrays are 0-based though)
        // 
        // Then loop through the cards in the array to see if there's a match.
        
        // If the guess is successful, print System.out.println("Congratulations, you guessed right!");.
        
    

    /**
     * A simple method to print out personal information. Follow the instructions to 
     * replace this information with your own.
     * @author Paul Bonenfant Jan 2022
     */
    public static int[] getInput(){
		Scanner key = new Scanner(System.in);
		int temp[] = new int[2];
		System.out.print("\n--------Pick a card and see if it matches!--------\n"
				+ "\nEnter a card integer value (1-13 ace to king): ");
		temp[0] = key.nextInt();
		System.out.print("\nEnter a card integer value (1-4; hearts, clubs, spades, diamonds): ");
		temp[1] = key.nextInt();
		return temp;
    }
    
	public static int[][] makeDeck(){ //makes it so that there are no duplicates
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
	
	public static int[][] shuffle(int[][] cards) { //shuffles the list of cards so that i have a random list with no duplicates
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
	
    private static void printInfo() {
    
        System.out.println("\n-------------Congratulations, you guessed right!-------------");
        System.out.println();
        
        System.out.println("My name is Jordan, but you can call me Nadroj, Jord or prime minister");
        System.out.println();
        
        System.out.println("My career ambitions: Destroy the world");
        System.out.println("Dont Be more active on LinkedIn");
        System.out.println("I will Have a semester with no violations of academic integrity cuz im so good that id never need to cheat");
	System.out.println();	

        System.out.println("My hobbies:");
        System.out.println("Making dumb programs");
        System.out.println("Gamer");
        System.out.println("Weeb");
        System.out.println("spending time with my soon to be wife");

        System.out.println();
        
    
    }

}

