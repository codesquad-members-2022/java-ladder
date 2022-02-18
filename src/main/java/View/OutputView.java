package View;

import domain.LadderGame;

public class OutputView {

    public static void showLadder(LadderGame ladderGame) {
        System.out.println(ladderGame.toString());
    }

    public static void showNames(Names names) {
        System.out.println(names.toString());
    }
}
