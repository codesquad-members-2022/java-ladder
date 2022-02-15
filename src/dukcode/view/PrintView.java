package dukcode.view;

import dukcode.model.Ladder;

public class PrintView {
    private final Ladder ladder;

    public PrintView(Ladder ladder) {
        this.ladder = ladder;
    }

    public void printLadder() {
        System.out.println(ladder.toString());
    }

}
