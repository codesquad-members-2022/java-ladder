package com.sh.domains;

import static com.sh.utils.InputVerification.*;

import java.util.List;
import java.util.function.Function;

public class LadderService {
	private static final String SYMBOL_IS_LADDER = "-----";
	private static final String SYMBOL_IS_NOT_LADDER = String.format("%5s"," ");
	private static final String SYMBOL_TRANSVERSE= "|";
	private static final int SYMBOL_HALF_LENGTH_OF_NAME = MAX_LENGTH_OF_NAME/2;
	private final Players players;
	private final Ladder ladder;
	private Function<Boolean, String> toLadderOrNot = (isLadder) -> (isLadder ? SYMBOL_IS_LADDER :
		SYMBOL_IS_NOT_LADDER);

	public LadderService(Players players, Ladder ladder) {
		this.players = players;
		this.ladder = ladder;
	}

	public String resultOfPlay() {
		ladder.play();
		ladder.getLadders();
		return toText();
	}

	private String toText() {
		StringBuilder sb = new StringBuilder();
		toNames(sb);
		toLadders(sb);
		return sb.toString();
	}

	private void toLadders(StringBuilder sb) {
		List<List<Boolean>> ladders = this.ladder.getLadders();
		for (List<Boolean> ladder : ladders) {
			toLineByText(sb, ladder);
		}
	}

	private void toNames(StringBuilder sb) {
		List<String> names = players.getNames();
		for (String name : names) {
			String formatName = "";
			formatName = fixLength(name);
			sb.append(formatName);
		}
		sb.append(System.lineSeparator());
	}

	private String fixRightLength(String name) {
		return String.format("%-6.5s", name);
	}

	private String fixLength(String name) {
		if (name.length() <= SYMBOL_HALF_LENGTH_OF_NAME) {
			return String.format("%3s   ", name);
		}
		return fixRightLength(name);
	}

	private void toLineByText(StringBuilder sb, List<Boolean> ladderLines) {
		String transverse = String.format("%3s", SYMBOL_TRANSVERSE);
		sb.append(transverse);
		for (boolean isLadder : ladderLines) {
			String symbol = toLadderOrNot.apply(isLadder);
			sb.append(symbol)
				.append(SYMBOL_TRANSVERSE);
		}
		sb.append(System.lineSeparator());
	}
}
