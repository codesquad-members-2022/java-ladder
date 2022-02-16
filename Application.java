import java.io.IOException;
import java.util.List;

public class Application {
	private static void run() throws IOException {
		InputView inputView = new InputView();
		List<String> playerNames = inputView.getPlayerName();
		int ladderHeight = inputView.getLadderHeight();


		Ladder ladder = new Ladder();
		ladder.setWidth(playerNames);
		List<List<String>> ladderForGame = ladder.make(ladderHeight);

		OutView outView = new OutView();
		outView.printPlayerName(playerNames);
		outView.print(ladderForGame);
	}

	public static void main(String[] args) throws IOException {
		run();
	}
}
