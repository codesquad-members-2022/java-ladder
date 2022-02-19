package ladder.domain;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.Name;
import ladder.domain.user.Names;
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
        Ladder ladder = ladderGame.getLadder(names, height);
        outputView.print(ladder.getLadderLines(), names);

        Name name = inputView.getPlayerName();
        while (name.isNotEqualToEndCondition()) {

            name = inputView.getPlayerName();
        }

    }

}
