
public class Game {
	
	public static void main(String args[]) {
		Deck mDeck = new Deck();
		mDeck.initDeck();	
		
		Hand temp = new Hand(mDeck);
		
		System.out.println(temp.getHandResult());	
		System.out.println(temp);
	}
}
