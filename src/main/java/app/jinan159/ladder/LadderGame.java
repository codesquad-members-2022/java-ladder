package app.jinan159.ladder;

import app.jinan159.ladder.view.InputView;
import app.jinan159.ladder.view.OutputView;
import app.jinan159.ladder.domain.gamemap.GameMap;
import app.jinan159.ladder.domain.Participant;

import java.io.IOException;
import java.util.List;

public class LadderGame {

    public static final int MAX_NAME_LENGTH = 5;

    private final GameMap gameMap;
    private final List<Participant> participants;

    public LadderGame() throws IOException {
        try (InputView reader = new InputView()) {
            this.participants = reader.readParticipants();
            int height = reader.readHeight();
            this.gameMap = new GameMap(participants.size(), height);
        }
    }

    // ------- public method ---------
    public void startGame() throws IOException {
        try (OutputView writer = new OutputView()) {
            writer.writeParticipants(this.participants);
            writer.writeGameMap(gameMap);
        }
    }

    private String getPad(int count) {
        return " ".repeat(Math.max(0, count));
    }

}
