package main.com;

import java.io.IOException;

import main.com.domain.Ladder;
import main.com.view.InputView;
import main.com.view.OutputView;

public class Application {
	private static void run() throws IOException {
		InputView inputView = new InputView();
		Ladder ladder = new Ladder();
		OutputView outputView = new OutputView();

		String[] playerNames = inputView.getPlayerName();
		int ladderHeight = inputView.getLadderHeight();

		ladder.setWidth(playerNames);
		Ladder ladderForGame = ladder.make(ladderHeight);

		outputView.printPlayerName(playerNames);
		outputView.print(ladderForGame);
	}

	public static void main(String[] args) throws IOException {
		run();
	}
}
