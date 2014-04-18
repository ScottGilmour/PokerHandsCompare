import java.util.ArrayList;
import java.util.Random;

public class Deck {
	static ArrayList<Card> cardDeck;
	private static Random randomGen;
	
	public Deck() {
		initDeck();
	}
	
	void initDeck() {
		cardDeck = new ArrayList<Card>();
		
		for (int suits = 0; suits < 4; suits++) {
			for (int faces = 0; faces < 13; faces++) {
				Card temp = new Card(Face.values()[faces], Suit.values()[suits]);
				cardDeck.add(temp);
			}
		}
	}
	
	static Card getRandomCardFromDeck() {
		randomGen = new Random();
		int index = randomGen.nextInt(cardDeck.size()-1);
		
		Card card = cardDeck.get(index);
		cardDeck.remove(index);
		
		return card;
	}
	
	void printDeck() {
		for (int i = 0; i < 52; i++) {
			System.out.println(cardDeck.get(i).toString());
		}
	}
}
