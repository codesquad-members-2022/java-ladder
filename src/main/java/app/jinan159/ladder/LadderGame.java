package app.jinan159.ladder;

import app.jinan159.ladder.io.InputReader;
import app.jinan159.ladder.io.OutputWriter;
import app.jinan159.ladder.meta.GameMap;
import app.jinan159.ladder.meta.Participant;

import java.io.IOException;
import java.util.List;

public class LadderGame {

    private final GameMap gameMap;
    private final List<Participant> participants;

    public LadderGame() throws IOException {
        try (InputReader reader = new InputReader()) {
            this.participants = reader.readParticipants();
            int height = reader.readHeight();
            this.gameMap = new GameMap(participants.size(), height);
        }
    }

    // ------- public method ---------
    public void startGame() throws IOException {
        try (OutputWriter writer = new OutputWriter()) {
            writer.write(gameMap.gameMapToString());
        }
    }
}
