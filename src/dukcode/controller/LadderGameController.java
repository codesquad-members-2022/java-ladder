package dukcode.controller;

import dukcode.ladder.Ladder;
import dukcode.view.PrintView;

public class LadderGameController {
    private final Ladder ladder;
    private final PrintView printView;

    public LadderGameController(PrintView printView, Ladder ladder) {
        this.printView = printView;
        this.ladder = ladder;
    }

    public void initLadder(String[] namePlayers, String[] results, int height) {
        ladder.init(namePlayers, results, height);
    }

    public void updatePrintView() {
        printView.printGame();
    }
}
