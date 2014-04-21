
public class Card {
	Suit cardSuit;
	Face cardFace;
	
	public Card(Face face, Suit suit) {
		this.cardFace = face;
		this.cardSuit = suit;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [cardSuit=" + cardSuit + ", cardFace=" + cardFace + "]";
	}

	/**
	 * @return the cardSuit
	 */
	public Suit getCardSuit() {
		return cardSuit;
	}
	
	/**
	 * @param cardSuit the cardSuit to set
	 */
	public void setCardSuit(Suit cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	/**
	 * @return the cardFace
	 */
	public Face getCardFace() {
		return cardFace;
	}
	
	/**
	 * @param cardFace the cardFace to set
	 */
	public void setCardFace(Face cardFace) {
		this.cardFace = cardFace;
	}
}
