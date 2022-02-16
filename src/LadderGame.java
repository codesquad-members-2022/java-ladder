import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LadderGame {

	private char[][] ladderFrame;
	private boolean[][] ladderFoothold;
	private List<String> users;
	private Random random;
	private int userNumber;
	private int ladderHeight;

	private void init() {
		users = Input.getUserName();
		userNumber = users.size();
		ladderHeight = Input.getLadderHeight("최대 사다리 높이는 몇 개인가요?");
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
