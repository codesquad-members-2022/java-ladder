
class Ladder {
	char[][] makeLadder(int peopleNumber, int ladderHeight){
		char[][] ladder = new char[ladderHeight][(peopleNumber * 2) - 1];
		LadderLine ladderLine = new LadderLine();

		for(int row = 0; row < ladder.length; row++){
			for(int column = 0; column < ladder[0].length; column++){
				ladder[row][column] = ladderLine.makeLadderLine(column);
			}
		}

		return ladder;
	}
}
