package ladder.model;

import ladder.model.ladder.Height;
import ladder.model.ladder.LadderLines;
import ladder.system.Configuration;
import ladder.view.InputView;
import ladder.view.OutputView;

public class GameManager {

    private static InputView inputView;
    private static OutputView outputView;
    private static LadderGame ladderGame;

    private static final GameManager instance = new GameManager();

    private GameManager() {
        inputView = Configuration.inputView;
        outputView = Configuration.outputView;
        ladderGame = Configuration.ladderGame;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            return new GameManager();
        }
        return instance;
    }

    public void startGame() throws Exception {
        Names names = inputView.getPlayerNames();
        Height height = inputView.getHeight();
        Count count = Counts.of(names.size());

        LadderLines ladderLines = new LadderLines(count, height);
        outputView.print(ladderLines, names);
    }
}
