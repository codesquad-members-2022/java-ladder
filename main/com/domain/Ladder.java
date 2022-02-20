package main.java.domain;

import java.util.ArrayList;
import java.util.List;


public class Ladder {
	private static final List<List<String>> ladderForGame = new ArrayList<>();
	private int width;

	private int getWidth(String[] playerNames){
		return (playerNames.length * 2) - 1;
	}

	public void setWidth(String[] playerNames) {
		this.width = getWidth(playerNames);
	}

	List<String> getLadderRow(int width){
		LadderRow ladderRow = new LadderRow();
		return ladderRow.make(width);
	}

	public List<List<String>> make(int height){
		for(int rowNumber = 0; rowNumber < height; rowNumber++){
			List<String> row = getLadderRow(this.width);
			ladderForGame.add(row);
		}

		return ladderForGame;
	}
}
