package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.view.Input;
import ladder.view.PrintLadder;

public class LadderGame {

	private List<LadderLine> ladder;
	private List<User> users;
	private List<String> userResult;
	private int userNumber;
	private int ladderHeight;

	public void start() {
		init();
		PrintLadder.printLadder(ladder, users);
		Input.close();
	}
	private void init() {
		ladder = new ArrayList<>();
		getUserName();
		getUserResult();
		getLadderHeight();
		makeLadder();
		//todo 사람과 결과 이어주어야 함
	}
	private void getUserName() {
		users = Input.getUserName();
		userNumber = users.size();
	}
	private void getUserResult() {
		userResult = Input.getUserResult();
		while (userResult.size() != userNumber) {
			userResult = Input.getUserResult();
		}
	}
	private void getLadderHeight() {
		ladderHeight = Input.getLadderHeight("최대 사다리 높이는 몇 개인가요?");
	}
	private void makeLadder() {
		for (int i = 0; i < ladderHeight; i++) {
			ladder.add(new LadderLine(userNumber));
		}
	}

}
