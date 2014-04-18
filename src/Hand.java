import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Hand {
	Card[] dealtCards;
	
	@Override
	public String toString() {
		return "Hand [dealtCards=" + Arrays.toString(dealtCards) + "]";
	}

	public Hand() {
		dealtCards = new Card[5];
		initHand();
	}

	private void initHand() {
		for (int i = 0; i < dealtCards.length; i++) {
			dealtCards[i] = Deck.getRandomCardFromDeck();
		}
	}
	
	private void sortHand() {
		Comparator<Card> sortCards = new Comparator<Card>() {
			@Override
			public int compare(Card arg0, Card arg1) {
				if (arg0.getCardFace().ordinal() > arg1.getCardFace().ordinal())
					return 1;
				else if (arg0.getCardFace().ordinal() < arg1.getCardFace().ordinal())
					return -1;
				else if (arg0.getCardFace().ordinal() == arg1.getCardFace().ordinal())
					return 0;
				
				return 0;
			}
		};
		
		Arrays.sort(dealtCards, sortCards);
	}
	
	public HandResult getHandResult() {		
		return analyzeHand();
	}

	private HandResult analyzeHand() {
		//Current hand strength
		HandResult curResult = HandResult.HIGHCARD;
		sortHand();
		
		int matches = 0, flush = 0, straight = 0;
		ArrayList<Card> trashStraight = new ArrayList<Card>();
	
		for (Card card : dealtCards) {
			for (Card cardCompare : dealtCards) {
				//If comparing with oneself, continue
				if (card == cardCompare)
					continue;
					
				//If the card we are comparing too has not been checked, determine if its face value is one greater than our card
				if ((Face.getIntForFace(cardCompare.getCardFace()) + 1) == Face.getIntForFace(card.getCardFace())) {
					if (!trashStraight.contains(cardCompare)) {
						straight++;
						trashStraight.add(cardCompare);
						break;
					}
				}
			}
		}
		
		//Second pass thorugh cards to determine pairs, three of a kind, flush, etc.
		for (Card card : dealtCards) {
			for (Card cardCompare : dealtCards) {
				
				if (card == cardCompare) {
					matches++;
					continue;
				}
					
				if (card.getCardFace() == cardCompare.getCardFace()) {
					matches++;
				}
				
				if (card.getCardSuit() == cardCompare.getCardSuit()) {
					flush++;
				}
			}
		}
		
		//If counting fields are equal to required cards, set the current hand result to straight/flush/straightflush
		if (straight == 4)
			curResult = HandResult.STRAIGHT;
		
		if (flush == 20)
			curResult = HandResult.FLUSH;
		
		if (flush == 20 && straight == 4)
			curResult = HandResult.STRAIGHTFLUSH;
		
		//Determine what the matches are
		switch (matches) {
			case 7:
				if (curResult.compare(curResult, HandResult.ONEPAIR) == -1)
					curResult = HandResult.ONEPAIR;
				break;
				
			case 9:
				if (curResult.compare(curResult, HandResult.TWOPAIR) == -1)
					curResult = HandResult.TWOPAIR;
				break;
				
			case 11:
				if (curResult.compare(curResult, HandResult.THREEOFAKIND) == -1)
					curResult = HandResult.THREEOFAKIND;
				break;
				
			case 13:
				if (curResult.compare(curResult, HandResult.FULLHOUSE) == -1)
					curResult = HandResult.FULLHOUSE;
				break;
				
			case 14:
				if (curResult.compare(curResult, HandResult.FOUROFAKIND) == -1)
					curResult = HandResult.FOUROFAKIND;
				break;
		}
		return curResult;
	}
}
