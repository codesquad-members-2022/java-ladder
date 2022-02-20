package dukcode.view;

import dukcode.ladder.view.LadderView;

public class PrintView {
    private final LadderView ladderView;

    public PrintView(LadderView ladderView) {
        this.ladderView = ladderView;
    }

    public void printGame() {
        System.out.println("\n실행결과\n");
        System.out.println(ladderView.getPlayersName());
        System.out.println(ladderView.getLadderString());
        System.out.println(ladderView.getResults());
    }
}
