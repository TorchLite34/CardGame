import java.util.Scanner;

public class CardTest {

	public static void main(String[] args) {
		
		Deck d1 = new Deck();
		d1.shuffle();

     	Hand h1 = new Hand(2);
     	h1.getHand(d1);
//     	System.out.println("\nYour first hand is: \n" + h1.toString());
     	
     	Hand h2 = new Hand(2);
     	h2.getHand(d1);
//     	System.out.println("\nYour Second hand is: \n" + h2.toString());
     	
     	Hand p1 = new Hand(1);
     	p1.getHand(d1);
     	System.out.println("\nThe top card is: \n" + p1.displayTop());
     	

     	while(true) {
			System.out.println("\n____Your hand____\n" + h1.toString());
     		Scanner keyboard = new Scanner(System.in);
     		System.out.print("\nChoose an integer action"
     				+ "\n1: draw"
     				+ "\n2: play"
     				+ "\n3: give"
     				+ "\n4: discard\nPress Enter to continue: ");
     		int opt = keyboard.nextInt();
     		switch(opt) {
     			case 1:
     				h1.draw(d1, h1.getNum());
     				break;
     			case 2:
     				h1.give(p1, h1.getNum());
     		     	System.out.println("\nThe top card is: \n" + p1.displayTop());
     		     	System.out.println(p1.toString());
     		     	break;
     		}
     		
     			
     	}
	}

}
