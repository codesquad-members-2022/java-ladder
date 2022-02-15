package controller;

import domain.Ladder;
import view.InputView;
import view.OutputView;

public class GameController {

    public void ladderGameStart() {
        Ladder ladder = gameReady();
        OutputView.printLadder(ladder);
    }

    private Ladder gameReady() {
        int playersCount = InputView.getPlayersCount();
        int maxLadderHeight = InputView.getMaxLadderHeight();

        Ladder ladder = new Ladder(playersCount, maxLadderHeight);
        ladder.generateLadder();

        return ladder;
    }
}
