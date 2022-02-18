package dukcode.controller;

import dukcode.model.Ladder;
import dukcode.view.PrintView;

public class LadderController {
    private final Ladder ladder;
    private final PrintView printView;

    public LadderController(PrintView printView, Ladder ladder) {
        this.printView = printView;
        this.ladder = ladder;
    }

    public void initLadder(String[] namePlayers, int height) {
        ladder.init(namePlayers, height);
    }

    public void updatePrintView() {
        printView.printGame();
    }
}
