package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ladder.view.Input;
import ladder.view.PrintLadder;

public class LadderGame {

	private static final String BLANK = " ";

	private List<LadderLine> ladder;
	private List<User> users;
	private List<String> userResultInput;
	private Map<User, String> gameResult;
	private int userNumber;
	private int ladderHeight;

	public void start() {
		init();
		PrintLadder.printLadder(users, ladder, userResultInput);
		//todo 결과를 보고 싶은 사람 & 실행 결과 (gameResult 매개변수)
		// while(ture) 로 계속 돌려야할듯
		Input.close();
	}
	private void init() {
		ladder = new ArrayList<>();
		gameResult = new HashMap<>();
		getUserName();
		getUserResult();
		getLadderHeight();
		makeLadder();
		linkUserAndResult();
	}
	private void getUserName() {
		users = Input.getUserName();
		userNumber = users.size();
	}
	private void getUserResult() {
		userResultInput = Input.getUserResult();
		while (userResultInput.size() != userNumber) {
			userResultInput = Input.getUserResult();
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
	private void linkUserAndResult() {
		for (int i = 0; i < userNumber; i++) {
			gameResult.put(users.get(i), checkResult(i));
		}
	}
	private String checkResult(int idx) {
		int line = idx * 6 + 1;
		for (int i = 0; i < ladderHeight; i++) {
			line = userPath(line, i);
		}
		return userResultInput.get((line - 1) / 6);
	}

	private int userPath(int line, int i) {
		if (isExistLeftStep(line, i)) {
			line -= 6;
		} else if (isExistRightStep(line, i)) {
			line += 6;
		}
		return line;
	}

	private boolean isExistRightStep(int line, int i) {
		return getLadderLineWithPadding(i).substring(line + 1, line + 2).contains("-");
	}

	private boolean isExistLeftStep(int line, int i) {
		return getLadderLineWithPadding(i).substring(line - 1, line).contains("-");
	}

	private String getLadderLineWithPadding(int i) {
		return BLANK + ladder.get(i).toString() + BLANK;
	}

}
