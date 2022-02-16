package ladder.system;

import ladder.model.GameManager;
import ladder.utils.RandomGenerator;

public class Configuration {
    public static final RandomGenerator randomGenerator = RandomGenerator.getInstance();
    public static final GameManager gameManager = GameManager.getInstance();
}
