package com.sh.utils;

import static com.sh.utils.GameMessage.*;

import java.util.function.Consumer;
import java.util.function.Function;

public class Output {
	private static Function<Boolean, String> toLadderOrNot = (isLadder) -> (isLadder ? SYMBOL_IS_LADDER :
		SYMBOL_IS_NOT_LADDER);
	public static Consumer<String> print = (text) -> System.out.print(text);
	public static Consumer<String> println = (text) -> System.out.println(text);
	public static Consumer<Object> prints = (obj) -> System.out.println(obj);

	public static String resultOfPlay(boolean[][] ladders) {
		StringBuilder sb = new StringBuilder();
		for (boolean[] ladderLines : ladders) {
			sb.append(SYMBOL_LINE);
			toLineByText(sb, ladderLines);
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	private static void toLineByText(StringBuilder sb, boolean[] ladderLines) {
		for (boolean isLadder : ladderLines) {
			String symbol = toLadderOrNot.apply(isLadder);
			sb.append(symbol)
				.append(SYMBOL_LINE);
		}
	}
}
