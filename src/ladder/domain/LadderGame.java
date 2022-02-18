package ladder.domain;

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
		showResult();
		InputView.close();
	}

	private void init() {
		setUserName();
		setUserResult();
		this.ladder = new Ladder(userNumber, getLadderHeight(), users, userResultInput);
		ladder.makeLadderAndCheckResult();
		OutputView.printLadder(users, ladder.getLadderInfoList(), userResultInput);
	}

	private void setUserName() {
		users = InputView.getUserName();
		userNumber = users.size();
	}

	private void setUserResult() {
		userResultInput = InputView.getUserResult();
		while (userResultInput.size() != userNumber) {
			userResultInput = InputView.getUserResult();
		}
	}

	private int getLadderHeight() {
		return InputView.getLadderHeight("최대 사다리 높이는 몇 개인가요?");
	}

	private boolean showResult() {
		String command = InputView.getUserCommand();
		if (command.equals("춘식이")) {
			return false;
		}
		if (command.equals("all")) {
			OutputView.printGameResult(ladder.getGameResult());
			return showResult();
		}
		OutputView.printGameResult(ladder.getGameResult().get(new User(command)));
		return showResult();
	}

}
