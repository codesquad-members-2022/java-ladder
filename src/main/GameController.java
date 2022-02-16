package main;

import main.domain.LadderGame;
import main.util.InputUtil;
import main.view.InputView;
import main.view.OutputView;

public class GameController {

    public void run() {
        try {
            LadderGame ladderGame = new LadderGame(
                InputUtil.parseNames(InputView.getNames()),
                InputView.getNumLadder()
            );
            OutputView.printGame(ladderGame);

        } catch (IllegalArgumentException e) {
            OutputView.printIllegalException();
        }

        InputView.close();
    }
}
