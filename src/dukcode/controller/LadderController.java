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

    public void initLadder(int numPlayer, int height) {
        ladder.init(numPlayer, height);
    }

    public void updatePrintView() {
        printView.printLadder();
    }
}
