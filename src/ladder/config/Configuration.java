package ladder.config;

import ladder.model.GameManager;
import ladder.model.LadderGame;
import ladder.utils.RandomGenerator;

public class Configuration {

    public static final GameManager gameManager = GameManager.getInstance();
    public static final RandomGenerator randomGenerator = RandomGenerator.getInstance();
}
