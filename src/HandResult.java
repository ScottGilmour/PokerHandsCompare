
public enum HandResult {
	HIGHCARD (0), ONEPAIR (1), TWOPAIR (2), THREEOFAKIND (3), STRAIGHT (4), FLUSH (5), FULLHOUSE (6), FOUROFAKIND (7), STRAIGHTFLUSH (8);
	
	private final int value;
	
	HandResult(int val) {
		this.value = val;
	}
	
	public int getValueForResult() {
		return this.value;
	}
	
	int compare(HandResult src, HandResult dest) {
		
		if (src.getValueForResult() > dest.getValueForResult())
			return 1;
		else if (src.getValueForResult() < dest.getValueForResult())
			return -1;
		else if (src.getValueForResult() == dest.getValueForResult())
			return 0;
				
		return -2;
	}
}
