package main.com.domain;

import java.util.Random;

public class LadderLine {
	private static final	Random random = new Random();
	private static final String VERTICAL_LINE = "|";
	private static final String HORIZONTAL_LINE = "-----";
	private static final String BLANK = "     ";

	public String element;
	private boolean hasLine = true;

	LadderLine() {}

	LadderLine(String line){
		this.element = line;
	}

	LadderLine make(int column){
		if(column % 2 == 0){
			setRandom();
			return new LadderLine(VERTICAL_LINE);
		}

		if(hasLine){
			return new LadderLine(HORIZONTAL_LINE);
		}

		return new LadderLine(BLANK);
	}

	private void setRandom() {
		hasLine = random.nextBoolean();
	}
}