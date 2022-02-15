package controller;

import domain.Ladder;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public void start() {
        Ladder ladder = ready();
        OutputView.printLadder(ladder);
    }

    private Ladder ready() {
        int playersCount = InputView.getPlayersCount();
        int maxLadderHeight = InputView.getMaxLadderHeight();

        Ladder ladder = new Ladder(playersCount, maxLadderHeight);
        ladder.generateLadder();

        return ladder;
    }
}
