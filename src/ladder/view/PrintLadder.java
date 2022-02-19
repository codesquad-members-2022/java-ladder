package ladder.view;

import java.util.List;
import ladder.domain.LadderLine;
import ladder.domain.User;

public class PrintLadder {

	private static final StringBuilder sb = new StringBuilder();

	private PrintLadder() {}

	public static void printLadder(List<LadderLine> ladders, List<User> users) {

		for (User user : users) {
			sb.append(user).append(" ");
		}
		sb.append("\n");

		for (LadderLine ladder : ladders) {
			sb.append("  ").append(ladder).append("\n");
		}

		System.out.println(sb);
		sb.setLength(0);
	}

}
