import java.util.Random;

public class Ladder {

	private String ladder;
	private static Random ran = new Random();

	public Ladder(int userNumber) {
		int ladderRow = 2 * userNumber - 1;
		makeLadder(ladderRow);
	}

	private void makeLadder(int ladderRow) {

	}


	@Override
	public String toString() {
		return ladder;
	}
}
