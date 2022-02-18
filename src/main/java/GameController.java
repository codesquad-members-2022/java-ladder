import View.InputView;
import View.OutputView;
import domain.Ladder;
import domain.LadderGame;

public class GameController {

    private Board board;
    private Names names;

    public void init() {
        String playerNames = InputView.askPlayers();
        int height = InputView.askLadderHeight();
        names = new Names(playerNames);
        board = new Board(names.getPlayersCount(), height);
    }

    public void run() {
        LadderGame ladderGame = InputView.askSettingLadder();
        InputView.close();
        OutputView.showLadder(ladderGame);
    }

    public void showResult() {
        OutputView.showNames(names);
        OutputView.showBoard(board);
    }
}
