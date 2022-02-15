import View.InputView;
import View.OutputView;
import domain.Board;

public class Main {

    public static void main(String[] args) {

        int count = InputView.askHowManyPlayers();
        int height = InputView.askLadderHeight();

        Board board = new Board(count,height);
        board.generateFrame();

        OutputView.showBoard(board);

    }
}