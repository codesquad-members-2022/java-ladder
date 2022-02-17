package View;

import domain.Ladder;
import domain.Names;

public class OutputView {

    public static void showBoard(Ladder board) {
        System.out.println(board.toString());
    }

    public static void showNames(Names names) {
        System.out.println(names.toString());
    }
}