import java.io.IOException;
import java.util.List;

public class Application {
	public static void main(String[] args) throws IOException {
		InputView inputView = new InputView();
		List<String> playerNames = inputView.getPlayerName();
		int ladderHeight = inputView.getLadderHeight();


		Ladder ladder = new Ladder();
		char[][] ladderForGame = ladder.make(playerNames, ladderHeight);

		OutView outView = new OutView();
		outView.print(ladderForGame);
	}
}
