import java.util.Arrays;
import java.util.Comparator;

public class Hand {
	Card[] dealtCards;
	
	@Override
	public String toString() {
		return "Hand [dealtCards=" + Arrays.toString(dealtCards) + "]";
	}

	public Hand(Deck src) {
		dealtCards = new Card[5];
		initHand(src);
	}

	private void initHand(Deck deck) {
		for (int i = 0; i < 5; i++) {
			dealtCards[i] = deck.getRandomCardFromDeck();
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
		PokerHands mPokerHands = new PokerHands();
		HandResult curResult = HandResult.HIGHCARD;
		
		//Sort the hand from lowest to highest
		sortHand();
			
		//Use a histogram for determining pairs
		int[] histogram = new int[15];
		int flush = 0;
		
		//For each card in the hand
		for (int i = 0; i < dealtCards.length-1; i++) {
			//Increment the histogram for the cards face value
			histogram[dealtCards[i].getCardFace().getIntForFace()]++;
			
			//Increment the flush field if the neighbour card equals the current cards suit.
			if (dealtCards[i].getCardSuit() == dealtCards[i+1].getCardSuit()) {
				flush++;
			}
		}
		
		//Determine the hand from the histogram
		curResult = mPokerHands.getResultForHistogram(histogram);
		
		//If the difference between the last card and the first card is 4, it's a straight
		if ((dealtCards[0].getCardFace().getIntForFace() - dealtCards[4].getCardFace().getIntForFace()) == 4) {
			curResult = HandResult.STRAIGHT;
		}
		
		//If all 5 cards are the same suit, flush.
		if (flush == 4)
			curResult = HandResult.FLUSH;
		
		//If we had a straight and have a flush, straightflush
		if (flush == 4 && curResult == HandResult.STRAIGHT)
			curResult = HandResult.STRAIGHTFLUSH;
		
		return curResult;
	}
}


