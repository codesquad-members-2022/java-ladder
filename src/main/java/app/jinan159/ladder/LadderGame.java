package app.jinan159.ladder;

import app.jinan159.ladder.io.InputReader;
import app.jinan159.ladder.io.OutputWriter;
import app.jinan159.ladder.meta.LadderElement;
import app.jinan159.ladder.meta.GameMap;
import app.jinan159.ladder.stretegy.DefaultGameMapStretegy;
import app.jinan159.ladder.stretegy.LadderGameMapStretegy;

import java.io.IOException;

public class LadderGame {

    private final GameMap gameMap;
    private final LadderGameMapStretegy stretegy;

    public LadderGame() throws IOException {
        this(new DefaultGameMapStretegy());
    }

    public LadderGame(LadderGameMapStretegy stretegy) throws IOException {
        try (InputReader reader = new InputReader()) {
            int participantCount = reader.readParticipantCount();
            int height = reader.readHeight();
            this.gameMap = new GameMap(participantCount, height);
        }

        this.stretegy = stretegy;
        prepareGameMap(this.gameMap);
    }

    private void prepareGameMap(GameMap gameMap) {
        for (int y = 0; y < gameMap.getHeight(); y++) {
            prepareRow(gameMap, y);
        }
    }

    private void prepareRow(GameMap gameMap, int y) {
        for (int x = 0; x < gameMap.getWidth(); x++) {
            LadderElement element = stretegy.getLadderElementOnPotision(x, y);
            gameMap.set(x, y, element);
        }
    }

    // ------- public method ---------
    public void startGame() throws IOException {
        try (OutputWriter writer = new OutputWriter()) {
            writer.write(gameMap.gameMapToString());
        }
    }
}
