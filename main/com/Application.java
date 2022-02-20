package main.java;

import java.io.IOException;
import java.util.List;

import main.java.domain.Ladder;
import main.java.view.InputView;
import main.java.view.OutputView;

public class Application {
	private static void run() throws IOException {
		InputView inputView = new InputView();
		String[] playerNames = inputView.getPlayerName();
		int ladderHeight = inputView.getLadderHeight();


		Ladder ladder = new Ladder();
		ladder.setWidth(playerNames);
		List<List<String>> ladderForGame = ladder.make(ladderHeight);

		OutputView outputView = new OutputView();
		outputView.printPlayerName(playerNames);
		outputView.print(ladderForGame);
	}

	public static void main(String[] args) throws IOException {
		run();
	}
}
