package ladder.view;

import java.util.List;
import ladder.domain.LadderLine;
import ladder.domain.User;

public class OutputView {

	private static final StringBuilder sb = new StringBuilder();

	private OutputView() {}

	public static void printLadder(List<User> users, List<LadderLine> ladders, List<String> userResultInput) {

		appendUserInfo(users);
		appendLadder(ladders);
		appendResultInfo(userResultInput);

		System.out.println(sb);
		sb.setLength(0);
	}

	private static void appendUserInfo(List<User> users) {
		sb.append("  ");
		for (User user : users) {
			sb.append(user).append(" ");
		}
		sb.append("\n");
	}

	private static void appendLadder(List<LadderLine> ladders) {
		for (LadderLine ladder : ladders) {
			sb.append("    ").append(ladder).append("\n");
		}
	}

	private static void appendResultInfo(List<String> userResultInput) {
		for (String result : userResultInput) {
			sb.append(String.format("%6s", result));
		}
	}
	public static void printGameResult(Object result) {
		System.out.println(result);
	}

}
