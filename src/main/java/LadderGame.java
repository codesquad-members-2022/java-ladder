import View.InputView;
import View.OutputView;
import domain.Ladder;
import domain.Names;

public class LadderGame {

    private Ladder board;
    private Names names;

    public void init() {
        String playerNames = InputView.askPlayers();
        int height = InputView.askLadderHeight();
        names = new Names(playerNames);
        board = new Ladder(names, height);
    }

    public void run() {
        InputView.close();
    }

    public void showResult() {
        OutputView.showNames(names);
        OutputView.showBoard(board);
    }
}
