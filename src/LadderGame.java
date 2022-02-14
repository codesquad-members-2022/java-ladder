public class LadderGame {

	private char[][] ladder;

	private static final int USER_NUMBER_IDX = 0;
	private static final int MAX_LADDER_HEIGHT_IDX = 1;
	private int userNumber;
	private int ladderHeight;

	public void init() {
		int[] userInput = Input.getUserInput();
		userNumber = userInput[USER_NUMBER_IDX];
		ladderHeight = userInput[MAX_LADDER_HEIGHT_IDX];
	}

	public void start() {



	}


}
