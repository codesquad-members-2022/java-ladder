import java.util.List;

class Ladder {
	private int width;

	LadderLine ladderLine = new LadderLine();

	char[][] make(List<String> playerNames, int ladderHeight){
		this.width = getWidth(playerNames);

		char[][] ladder = new char [ladderHeight][width];

		for(int row = 0; row < ladderHeight; row++){
			getLine(row, ladder);
		}

		return ladder;
	}

	private int getWidth(List<String> playerNames){
		return (playerNames.size() * 2 - 1) * 5;
	}

	private void getLine(int row, char[][] ladder) {
		for (int column = 0; column < width; column++){
			ladder[row][column] = ladderLine.make(column);
		}
	}
}
