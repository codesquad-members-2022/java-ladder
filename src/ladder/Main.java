package ladder;

import ladder.model.GameManager;
import ladder.system.Configuration;

public class Main {
    public static void main(String[] args) throws Exception {
        GameManager gameManager = Configuration.gameManager;
        gameManager.startGame();
    }
}
