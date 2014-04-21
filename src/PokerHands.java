import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PokerHands {
	private HashMap<int[], HandResult> pokerHands = new HashMap<int[], HandResult>();
	
	int[] onepair = {2, 1, 1};
	int[] twopair = {2, 2, 0};
	int[] threeofakind = {3, 1, 0};
	int[] fullhouse = {3, 2, 0};
	int[] fourofakind = {4, 1, 0};
	
	public PokerHands() {	
		pokerHands.put(onepair, HandResult.ONEPAIR);
		pokerHands.put(twopair, HandResult.TWOPAIR);
		pokerHands.put(threeofakind, HandResult.THREEOFAKIND);
		pokerHands.put(fullhouse, HandResult.FULLHOUSE);
		pokerHands.put(fourofakind, HandResult.FOUROFAKIND);
	}
	
	HandResult getResultForHistogram(int[] src) {
		HandResult result = HandResult.HIGHCARD;
		
		for (Map.Entry<int[], HandResult> mEntry : pokerHands.entrySet()) {
			if (compareHistograms(src, mEntry.getKey())) {
				if (result.compare(result, mEntry.getValue()) == -1) {
					result = mEntry.getValue();
				}
			}
		}
		
		return result;
	}
	
	/*
	 *	Compares the last 3 elements of two arrays to check if they are equal 
	 */
	private boolean compareHistograms(int[] src, int[] dest) {
		int matches = 0, index = 2;
		
		Arrays.sort(src);
		Arrays.sort(dest);
		
		for (int i = src.length-1; i > (src.length-4); i--) {
			if (src[i] == dest[index]) {
				matches++;
				index--;
			}	
		}
		
		if (matches == 3) {
			return true;
		}
		
		return false;
	}
}
