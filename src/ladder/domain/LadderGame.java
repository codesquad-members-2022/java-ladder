package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {

	private List<User> users;
	private List<String> userResultInput;
	private Ladder ladder;
	private int userNumber;

	public void start() {
		init();
		keepShowResult();
		InputView.close();
	}

	private void keepShowResult() {
		boolean isKeep;
		do {
			String command = InputView.getUserName();
			isKeep = showResult(command);

		} while (isKeep);
	}

	private void init() {
		setUserName();
		setUserResult();
		this.ladder = new Ladder(userNumber, getLadderHeight(), users, userResultInput);
		ladder.makeLadderAndCheckResult();
		OutputView.printLadder(users, ladder.getLadderInfoList(), userResultInput);
	}

	private void setUserName() {
		users = convertInputToUsers(InputView.getUserCommand("참여할 사람 이름을 입력하세요."));
		userNumber = users.size();
	}

	private List<User> convertInputToUsers(List<String> userNames) {
		List<User> tmpUsers = new ArrayList<>();
		for (String userName : userNames) {
			tmpUsers.add(new User(userName));
		}
		return tmpUsers;
	}

	private void setUserResult() {
		do {
			userResultInput = InputView.getUserCommand("실행 결과를 입력하세요.");
		} while (userResultInput.size() != userNumber);
	}

	private int getLadderHeight() {
		return InputView.getLadderHeight("최대 사다리 높이는 몇 개인가요?");
	}

	private boolean showResult(String command) {
		if (command.equals("춘식이")) {
			return false;
		}
		if (command.equals("all")) {
			OutputView.printGameResultAll(ladder.getGameResult(), users);
			return true;
		}
		OutputView.printGameResult(ladder.getGameResult().get(new User(command)));
		return true;
	}

}
