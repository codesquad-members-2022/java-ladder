package View;

import domain.Ladder;
import domain.Names;

public class OutputView {

    public static void showLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

}