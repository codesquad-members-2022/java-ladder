package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

	private static final String BLANK = " ";

	private final List<LadderLine> ladderInfoList;
	private final Map<User, String> gameResult;
	private final List<String> userResultInput;
	private final List<User> users;
	private final int userNumber;
	private final int ladderHeight;

	public Ladder(int userNumber, int ladderHeight, List<User> users,
		List<String> userResultInput) {
		this.ladderInfoList = new ArrayList<>();
		this.gameResult = new HashMap<>();
		this.users = users;
		this.userResultInput = userResultInput;
		this.userNumber = userNumber;
		this.ladderHeight = ladderHeight;
	}

	public void makeLadderAndCheckResult() {
		for (int i = 0; i < ladderHeight; i++) {
			ladderInfoList.add(new LadderLine(userNumber));
		}
		linkUserAndResult();
	}
	public void linkUserAndResult() {
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
		return BLANK + ladderInfoList.get(i).toString() + BLANK;
	}

	public List<LadderLine> getLadderInfoList() {
		return ladderInfoList;
	}

	public Map<User, String> getGameResult() {
		return gameResult;
	}

}
