package main.com.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	public List<LadderRow> ladderForGame = new ArrayList<>();

	private int width;

	public Ladder() {}

	Ladder(List<LadderRow> rows) {
		this.ladderForGame = rows;
	}

	private int getWidth(String[] playerNames){
		return (playerNames.length * 2) - 1;
	}

	public void setWidth(String[] playerNames) {
		this.width = getWidth(playerNames);
	}

	LadderRow getLadderRow(int width){
		LadderRow ladderRow = new LadderRow();
		return ladderRow.make(width);
	}

	public Ladder make(int height){
		for(int rowNumber = 0; rowNumber < height; rowNumber++){
			LadderRow row = getLadderRow(this.width);
			ladderForGame.add(row);
		}

		return new Ladder(ladderForGame);
	}
}
