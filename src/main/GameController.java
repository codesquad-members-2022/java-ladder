package main;

import main.domain.LadderGame;
import main.util.StringUtil;
import main.view.InputView;
import main.view.OutputView;

public class GameController {

    public void run() {
        LadderGame ladderGame = new LadderGame(
            StringUtil.parseNames(InputView.getNames()),
            InputView.getNumLadder()
        );
        ladderGame.createMap();

        OutputView.printGame(ladderGame);
        InputView.closeScanner();
    }
}
