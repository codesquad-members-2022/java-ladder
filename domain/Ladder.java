package domain;

import java.util.ArrayList;
import java.util.List;


public class Ladder {
	private static final List<List<String>> ladder = new ArrayList<>();
	private int width;

	private int getWidth(List<String> playerNames){
		return (playerNames.size() * 2) - 1;
	}

	public void setWidth(List<String> playerNames) {
		this.width = getWidth(playerNames);
	}

	List<String> getLadderRow(int width){
		LadderRow ladderRow = new LadderRow();
		List<String> row = ladderRow.make(width);
		return row;
	}

	public List<List<String>> make(int height){
		for(int rowNumber = 0; rowNumber < height; rowNumber++){
			List<String> row = getLadderRow(this.width);
			ladder.add(row);
		}

		return ladder;
	}
}
