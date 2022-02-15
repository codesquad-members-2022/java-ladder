import View.InputView;
import View.OutputView;
import domain.Board;

public class LadderGame {

    private Board board;

    public void init() {
        int count = InputView.askHowManyPlayers();
        int height = InputView.askLadderHeight();
        board = new Board(count,height);
    }

    public void run() {
        board.generateFrame();
        OutputView.showBoard(board);
    }
}
