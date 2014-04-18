import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void testHands() {
		Deck testDeck = new Deck();
		Card testCard = new Card(Face.FIVE, Suit.HEARTS);
		Hand testHand = new Hand();
		Hand testHand2 = new Hand();
		
		assertNotNull(testDeck);
		assertNotNull(testCard);
		assertNotNull(testHand);
		assertNotNull(testHand2);
		
		assertNotSame(testHand, testHand2);
	}
	
	@Test(expected=NullPointerException.class)
	public void testGame() {
		Deck testDeck = new Deck();
		Hand testHand = new Hand();
		Hand testHand2 = null;
		
		Hand testWinningHand = Game.compareTwoHands(testHand, testHand2);
		
		assertNotNull(testWinningHand);
	}
}
