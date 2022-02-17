import View.InputView;
import View.OutputView;
import domain.Board;
import domain.Names;

public class LadderGame {

    private Board board;
    private Names names;

    public void init() {
        String playerNames = InputView.askPlayers();
        int height = InputView.askLadderHeight();
        names = new Names(playerNames);
        board = new Board(names, height);
    }

    public void run() {
        InputView.close();
        board.generateFrame();
    }

    public void showResult() {
        OutputView.showNames(names);
        OutputView.showBoard(board);
    }
}
