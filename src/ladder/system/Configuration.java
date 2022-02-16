package ladder.system;

import ladder.model.GameManager;
import ladder.model.LadderGame;
import ladder.model.ladder.Ladder;
import ladder.utils.RandomGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Configuration {


    private Configuration() {}
    private static Configuration instace = new Configuration();

    public static final RandomGenerator randomGenerator = RandomGenerator.getInstance();
    public static final InputView inputView = InputView.getInstance();
    public static final OutputView outputView = OutputView.getInstance();
    public static final LadderGame ladderGame = LadderGame.getInstance();
    public static final GameManager gameManager = GameManager.getInstance();
    public static final Ladder ladder = Ladder.getInstance();
}
