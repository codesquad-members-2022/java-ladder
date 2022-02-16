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
        InputView.init();
        int playersCount = InputView.getPlayersCount();
        int maxLadderHeight = InputView.getMaxLadderHeight();
        InputView.close();

        return Ladder.getLadder(playersCount, maxLadderHeight);
    }
}
