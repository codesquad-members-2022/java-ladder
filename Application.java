import java.io.IOException;

public class Application {
	public static void main(String[] args) throws IOException {
		InputView inputView = new InputView();
		int peopleNumber = inputView.getPeopleNumber();
		int ladderHeight = inputView.getLadderHeight();

		Ladder ladder = new Ladder();
		char[][] ladderForGame = ladder.makeLadder(peopleNumber, ladderHeight);

		OutView outView = new OutView();
		outView.print(ladderForGame);
	}
}
