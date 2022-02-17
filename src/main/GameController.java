package main;

import main.domain.LadderGame;
import main.util.InputUtil;
import main.view.InputView;
import main.view.OutputView;

public class GameController {

    public void run() {
        try {
            LadderGame game = new LadderGame(
                InputUtil.parseNames(InputView.getNames()),
                InputView.getNumLadder()
            );
            OutputView.printGame(game);

        } catch (IllegalArgumentException e) {
            OutputView.printIllegalException();
        }

        InputView.close();
    }
}
