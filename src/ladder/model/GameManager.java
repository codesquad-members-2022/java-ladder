package ladder.model;

import ladder.system.Configuration;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class GameManager {

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private LadderGame ladderGame = Configuration.ladderGame;

    private static final GameManager instance = new GameManager();

    private GameManager() {}

    public static final GameManager getInstance() {
        if (instance == null) {
            return new GameManager();
        }
        return instance;
    }

    public void startGame() {
        List<Integer> a = inputView.getWidthAndHeight();
    }
}
