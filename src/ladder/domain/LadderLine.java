package ladder.domain;

import java.util.Random;

public class LadderLine {

	private final StringBuilder ladder;
	private static final Random ran = new Random();
	private boolean previousStep = false;

	public LadderLine(int userNumber) {
		ladder = new StringBuilder();
		int ladderRow = 2 * userNumber - 1;
		makeLadder(ladderRow);
	}

	private void makeLadder(int ladderRow) {
		for (int i = 1; i <= ladderRow; i++) {
			makeLadderLine(i);
		}
	}

	private void makeLadderLine(int rowIdx) {
		if (rowIdx % 2 == 1) {
			ladder.append("|");
			return;
		}
		boolean isStep = isStep();
		ladder.append(isStep ? "-----" : "     ");
		previousStep = isStep;
	}

	private boolean isStep() {
		return !isExistPreviousStep() && ran.nextInt(2) == 0;
	}

	private boolean isExistPreviousStep() {
		return previousStep;
	}

	@Override
	public String toString() {
		return ladder.toString();
	}
}
