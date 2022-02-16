import java.util.Arrays;
import java.util.Random;

public class LadderGame {

	private char[][] ladderFrame;
	private boolean[][] ladderFoothold;
	private static final int USER_NUMBER_IDX = 0;
	private static final int LADDER_HEIGHT_IDX = 1;
	private Random random;
	private int userNumber;
	private int ladderHeight;

	private void init() {
		int[] userInput = Input.getUserInput();
		userNumber = userInput[USER_NUMBER_IDX];
		ladderHeight = userInput[LADDER_HEIGHT_IDX];
		random = new Random();
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

		int randomRepeatNum = random.nextInt(ladderHeight * (userNumber - 1));

		for (int i = 0; i < randomRepeatNum; i++) {
			ladderFoothold[random.nextInt(ladderHeight)][random.nextInt(userNumber - 1)] = true;
		}
	}

}
