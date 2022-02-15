import java.util.Random;

class LadderLine {
	private static final char LADDER_FRAME = '|';
	private static final char LADDER_LINE = '-';
	private static final char BLANK = ' ';

	char makeLadderLine(int column){
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
