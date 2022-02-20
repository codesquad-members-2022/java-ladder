package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

	private static final String PADDING = " ";
	private static final int EACH_WIDTH_OF_LADDER_SIZE = 6;

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
		int line = idx * EACH_WIDTH_OF_LADDER_SIZE + 1;
		for (int i = 0; i < ladderHeight; i++) {
			line = traceUserPath(line, i);
		}
		return userResultInput.get((line - 1) / EACH_WIDTH_OF_LADDER_SIZE);
	}

	private int traceUserPath(int line, int i) {
		if (isExistLeftStep(line, i)) {
			return line - EACH_WIDTH_OF_LADDER_SIZE;
		}
		if (isExistRightStep(line, i)) {
			return line + EACH_WIDTH_OF_LADDER_SIZE;
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
		return PADDING + ladderInfoList.get(i).toString() + PADDING;
	}

	public List<LadderLine> getLadderInfoList() {
		return ladderInfoList;
	}

	public Map<User, String> getGameResult() {
		return gameResult;
	}

}
