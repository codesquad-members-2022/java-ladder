package View;

<<<<<<< HEAD
import domain.Board;
import domain.Names;
=======
import domain.Ladder;
>>>>>>> 643e3fd (refactor : Names -> Players로 수정)

public class OutputView {

    public static void showBoard(Board board) {
        System.out.println(board.toString());
    }

    public static void showNames(Names names) {
        System.out.println(names.toString());
    }
}