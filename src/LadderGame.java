import java.util.Arrays;

public class LadderGame {

	private char[][] ladderFrame;
	private boolean[][] ladderFoothold;
	private static final int USER_NUMBER_IDX = 0;
	private static final int LADDER_HEIGHT_IDX = 1;
	private int userNumber;
	private int ladderHeight;

	private void init() {
		int[] userInput = Input.getUserInput();
		userNumber = userInput[USER_NUMBER_IDX];
		ladderHeight = userInput[LADDER_HEIGHT_IDX];
	}

	public void start() {
		init();
		makeLadder();
		PrintLadder.printLadder(ladderFrame, ladderFoothold);
		Input.close();
	}

	private void makeLadder() {
		makeLadderFrame();
		makeLadderFoothold();
	}

	private void makeLadderFrame() {
		ladderFrame = new char[ladderHeight][userNumber];

		for (char[] chars : ladderFrame) {
			Arrays.fill(chars, '|');
		}
	}

	private void makeLadderFoothold() {
		ladderFoothold = new boolean[ladderHeight][userNumber - 1];

		for (int i = 0; i < ladderHeight; i++) {
			for (int j = 0; j < userNumber - 1; j++) {
				if (Math.random() < 0.3f) {
					ladderFoothold[i][j] = true;
				}
			}
		}

	}

}
