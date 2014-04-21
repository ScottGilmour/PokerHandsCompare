import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cardDeck;
	
	void initDeck() {
		cardDeck = new ArrayList<Card>();
		
		for (int suits = 0; suits < 4; suits++) {
			for (int faces = 0; faces < 13; faces++) {
				Card temp = new Card(Face.values()[faces], Suit.values()[suits]);
				cardDeck.add(temp);
			}
		}
	}
	
	Card getRandomCardFromDeck() {
		return cardDeck.get(0 + (int)(Math.random() * (((cardDeck.size()-1) - 0) + 1)));
	}
	
	void printDeck() {
		for (int i = 0; i < 52; i++) {
			System.out.println(cardDeck.get(i).toString());
		}
	}
}
