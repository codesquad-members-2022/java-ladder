package main.controller;

import main.domain.Game;
import main.util.InputValidator;
import main.view.InputView;
import main.view.OutputView;

public class Executor {

    public void run() {
        OutputView.printParticipantsNameQueryText();
        String names = InputView.giveString();

        OutputView.printMaxHeightOfLadderQueryText();
        int maxHeightOfLadder = InputView.giveInt();

        validateInput(names, maxHeightOfLadder);

        Game game = new Game(names, maxHeightOfLadder);

        OutputView.printLadderBoard(names, game.getLadderBoard());

        InputView.close();
    }

    public void validateInput(String string, int num) {
        InputValidator.validateNames(string);
        InputValidator.checkPositiveInt(num);
    }
}
