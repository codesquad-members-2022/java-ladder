import java.util.ArrayList;
import java.util.List;

public class LadderGame {

	private List<User> users;
	private List<LadderLine> ladder;
	private int userNumber;
	private int ladderHeight;

	private void init() {
		ladder = new ArrayList<>();
		users = Input.getUserName();
		userNumber = users.size();
		ladderHeight = Input.getLadderHeight("최대 사다리 높이는 몇 개인가요?");
	}

	public void start() {
		init();
		makeLadder();
		PrintLadder.printLadder(ladder, users);
		Input.close();
	}

	private void makeLadder() {
		for (int i = 0; i < ladderHeight; i++) {
			ladder.add(new LadderLine(userNumber));
		}
	}

}
