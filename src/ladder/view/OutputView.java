package ladder.view;

import java.util.List;
import java.util.Map;
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
			sb.append(user.getUserName()).append(" ");
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
	public static void printGameResult(String result) {
		System.out.println(result);
	}

	public static void printGameResultAll(Map<User, String> gameResult, List<User> users) {
		for (User user : users) {
			sb.append(user.getUserName()).append(" : ").append(gameResult.get(user)).append("\n");
		}
		System.out.println(sb);
		sb.setLength(0);
	}
}
