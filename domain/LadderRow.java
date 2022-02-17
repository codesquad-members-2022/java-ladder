package domain;

import java.util.ArrayList;
import java.util.List;

class LadderRow {
	private static final String BLANK = "  ";
	private final List<String> row = new ArrayList<>();
	private final LadderLine ladderLine = new LadderLine();

	List<String> make(int width){
		row.add(BLANK);
		for(int column = 0; column < width; column++){
			String ladderElement = ladderLine.make(column);
			row.add(ladderElement);
		}
		return row;
	}
}
