
public class War extends Card{
	
	War(){
	}
	
	public String isGreater(Hand h1, Hand h2) {
		String str = h1 >= h2 ? (h1 == h2 ? "Same" : "h1 > h2") : "h2 > h1";
		return str;
		
	}
}
