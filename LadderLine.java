import java.util.Random;

class LadderLine {
	char makeLadderLine(int column){
		final char LADDER_FRAME = '|';
		final char LADDER_LINE = '-';
		final char BLANK = ' ';
		Random random = new Random();

		if(column % 2 == 0){
			return LADDER_FRAME;
		}

		if(random.nextBoolean()){
			return LADDER_LINE;
		}

		return BLANK;

	}
}
