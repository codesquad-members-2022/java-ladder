
class Ladder {
	String[][] makeLadder(int peopleNumber, int ladderHeight){
		String[][] ladder = new String[ladderHeight][(peopleNumber * 2) - 1];
		LadderLine ladderLine = new LadderLine();

		for(int row = 0; row < ladder.length; row++){
			for(int column = 0; column < ladder[0].length; column++){
				ladder[row][column] = ladderLine.makeLadderLine(column);
			}
		}

		return ladder;
	}
}
