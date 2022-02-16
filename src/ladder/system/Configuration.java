package ladder.system;

import ladder.model.GameManager;
import ladder.model.LadderGame;
import ladder.utils.RandomGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Configuration {
    public static final RandomGenerator randomGenerator = RandomGenerator.getInstance();
    public static final GameManager gameManager = GameManager.getInstance();
    public static final InputView inputView = InputView.getInstance();
    public static final OutputView outputView = OutputView.getInstance();
    public static LadderGame ladderGame = LadderGame.getInstance();
}
