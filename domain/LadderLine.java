package domain;

import java.util.Random;

class LadderLine {
	private static final	Random random = new Random();
	private static final String LADDER_FRAME = "|";
	private static final String LADDER_LINE = "-----";
	private static final String BLANK = "     ";
	private boolean hasLine = true;

	String make(int column){
		if(column % 2 == 0){
			setRandom();
			return LADDER_FRAME;
		}

		if(hasLine){
			return LADDER_LINE;
		}

		return BLANK;
	}

	void setRandom() {
		hasLine = random.nextBoolean();
	}
}