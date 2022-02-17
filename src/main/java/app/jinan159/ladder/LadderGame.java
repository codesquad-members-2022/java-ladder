package app.jinan159.ladder;

import app.jinan159.ladder.io.InputReader;
import app.jinan159.ladder.io.OutputWriter;
import app.jinan159.ladder.meta.gamemap.GameMap;
import app.jinan159.ladder.meta.Participant;

import java.io.IOException;
import java.util.List;

public class LadderGame {

    public static final int MAX_NAME_LENGTH = 5;

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
            writer.write(participantsToString(this.participants));
            writer.write(gameMap.gameMapToString());
        }
    }

    private String participantsToString(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getName)
                .map(this::padName)
                .reduce((nested, name) -> nested + " " + name)
                .orElse("") + "\n";
    }

    private String padName(String name) {
        if (name.length() == MAX_NAME_LENGTH) return name;

        int diff = MAX_NAME_LENGTH - name.length();
        int padCount1 = diff / 2;
        int padCount2 = diff - padCount1;

        if (padCount1 > padCount2) {
            return getPad(padCount1) + name + getPad(padCount2);
        }

        return getPad(padCount2) + name + getPad(padCount1);
    }

    private String getPad(int count) {
        return " ".repeat(Math.max(0, count));
    }

}
