package ladder.domain;

import java.util.List;
import ladder.view.Input;
import ladder.view.PrintLadder;

public class LadderGame {

	private List<User> users;
	private List<String> userResultInput;
	private Ladder ladder;
	private int userNumber;

	public void start() {
		init();
		PrintLadder.printLadder(users, ladder.getLadder(), userResultInput);
		//todo 결과를 보고 싶은 사람 & 실행 결과 (gameResult 매개변수)
		// while(ture) 로 계속 돌려야할듯
		Input.close();
	}
	private void init() {
		getUserName();
		getUserResult();
		this.ladder = new Ladder(userNumber, getLadderHeight(), users, userResultInput);
		ladder.makeLadderAndCheckResult();
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
	private int getLadderHeight() {
		return Input.getLadderHeight("최대 사다리 높이는 몇 개인가요?");
	}

}
