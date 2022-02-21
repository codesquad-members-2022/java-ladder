package com.sh.domains.ladders;

import static com.sh.views.InputVerification.*;

import java.util.List;
import java.util.function.Function;

import com.sh.domains.ladders.dtos.LadderDto;

public class LadderService {
	private static final String SYMBOL_IS_LADDER = "-----";
	private static final String SYMBOL_IS_NOT_LADDER = String.format("%5s"," ");
	private static final String SYMBOL_TRANSVERSE= "|";
	private static final int SYMBOL_HALF_LENGTH_OF_NAME = MAX_LENGTH_OF_NAME/2;
	private Function<Boolean, String> toLadderOrNot = (isLadder) -> (isLadder ? SYMBOL_IS_LADDER :
		SYMBOL_IS_NOT_LADDER);

	public LadderService() {}

	public Ladder createLadder(LadderDto ladderDto) {
		Ladder ladder = new Ladder(ladderDto.getNumberOfPeoples(), ladderDto.getHeight());
		return ladder;
	}

	public List<Integer> resultOfPlayers(Ladder ladder) {
		return ladder.playersResult();
	}

	public String resultOfLadder(Ladder ladder) {
		ladder.build();
		return toLadders(ladder);
	}

	private String toLadders(Ladder ladders) {
		StringBuilder sb = new StringBuilder();
		List<List<Boolean>> laddersBool = ladders.getLadders();
		for (List<Boolean> ladder : laddersBool) {
			buildLineByText(sb, ladder);
		}
		return sb.toString();
	}

	private void buildLineByText(StringBuilder sb, List<Boolean> ladderLines) {
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
