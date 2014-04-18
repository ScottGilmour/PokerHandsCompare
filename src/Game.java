//Scott Gilmour
//April 18th, 2014
//Compare two 5 card poker hands

public class Game {
	
	public static void main(String args[]) {
		//Create a new deck
		Deck mDeck = new Deck();
		
		//Create two demonstration hands, randomly generated with cards from the deck
		Hand handOne = new Hand();
		Hand handTwo = new Hand();
		
		//The winning hand is returned by the function compareTwoHands
		Hand winningHand = compareTwoHands(handOne, handTwo);
		
		System.out.println("Winning hand; " + winningHand.toString());
		System.out.println("Winning hand strength: " + winningHand.getHandResult());
	}
	
	public static Hand compareTwoHands(Hand hand1, Hand hand2) {
		
		//Get the hand result value (HandResult, TWOPAIR, THREEPAIR, etc) for each hand
		int handOne = HandResult.getValueForResult(hand1.getHandResult());
		int handTwo = HandResult.getValueForResult(hand2.getHandResult());
		
		//Determine greater hand & return
		if (handOne > handTwo)
			return hand1;
		else if (handTwo > handOne)
			return hand2;
		else if (handOne == handTwo)
			return hand1;
		
		return null;
	}
}
