package main.com.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
	private final LadderLine ladderLine = new LadderLine();
	public List<LadderLine> element = new ArrayList<>();

	LadderRow() {}

	LadderRow(List<LadderLine> lines){
		this.element = lines;
	}

	LadderRow make(int width){
		for(int column = 0; column < width; column++){
			LadderLine line = ladderLine.make(column);
			element.add(line);
		}
		return new LadderRow(element);
	}
}
