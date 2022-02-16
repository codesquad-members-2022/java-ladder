package controller;

import domain.Ladder;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public void start() {
        Ladder ladder = init();
        OutputView.printLadder(ladder);
    }

    private Ladder init() {
        InputView.createScanner();
        int playersCount = InputView.getPlayersCount();
        int maxLadderHeight = InputView.getMaxLadderHeight();
        InputView.closeScanner();

        return Ladder.getLadder(playersCount, maxLadderHeight);
    }
}
