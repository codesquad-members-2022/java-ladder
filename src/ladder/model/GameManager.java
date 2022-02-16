package ladder.model;

import ladder.view.InputView;
import ladder.view.OutputView;

public class GameManager {

    private LadderGame ladderGame;
    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private static final GameManager instance = new GameManager();

    private GameManager() {}

    public static final GameManager getInstance() {
        if (instance == null) {
            return new GameManager();
        }
        return instance;
    }

    public void startGame() {
        System.out.println("게임 시작");
    }
}
