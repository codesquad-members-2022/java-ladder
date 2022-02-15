class Ladder {
	private int width;

	LadderLine ladderLine = new LadderLine();

	char[][] makeLadder(int peopleNumber, int ladderHeight){
		this.width = getWidth(peopleNumber);

		char[][] ladder = new char [ladderHeight][width];

		for(int row = 0; row < ladderHeight; row++){
			getLadderLine(row, ladder);
		}

		return ladder;
	}

	private int getWidth(int peopleNumber){
		return peopleNumber * 2 - 1;
	}

	private void getLadderLine(int row, char[][] ladder) {
		for (int column = 0; column < width; column++){
			ladder[row][column] = ladderLine.makeLadderLine(column);
		}
	}
}
