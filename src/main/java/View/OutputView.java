package View;

import domain.Board;
import domain.Names;

public class OutputView {

    public static void showBoard(Board board) {
        System.out.println(board.toString());
    }

    public static void showNames(Names names) {
        System.out.println(names.toString());
    }
}