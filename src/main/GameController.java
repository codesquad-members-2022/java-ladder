package main;

import main.util.StringUtil;

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
