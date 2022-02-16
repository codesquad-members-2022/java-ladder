import java.util.Random;

public class LadderLine {

	private final StringBuilder ladder;
	private static final Random ran = new Random();
	private boolean previousStep = false;

	public LadderLine(int userNumber) {
		ladder = new StringBuilder();
		int ladderRow = 2 * userNumber - 1;
		makeLadderLine(ladderRow);
	}

	private void makeLadderLine(int ladderRow) {
		for (int i = 1; i <= ladderRow; i++) {
			if (i % 2 == 1) {
				ladder.append("|");
			} else {
				boolean step = isStep();
				previousStep = step;
				ladder.append(step ? "-----" : "     ");
			}

		}
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
