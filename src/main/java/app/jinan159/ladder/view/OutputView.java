package app.jinan159.ladder.view;

import app.jinan159.ladder.config.LadderGameConfig;
import app.jinan159.ladder.domain.Participant;
import app.jinan159.ladder.domain.gamemap.GameMap;
import app.jinan159.ladder.domain.gamemap.GameMapColumn;
import app.jinan159.ladder.domain.gamemap.GameMapRow;
import app.jinan159.ladder.utils.StringUtils;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView implements Closeable {

    private final OutputStreamWriter writer;

    public OutputView() {
        this.writer = new OutputStreamWriter(System.out);
    }

    public OutputView(OutputStream outputStream) {
        this.writer = new OutputStreamWriter(outputStream);
    }

    public void write(String s) throws IOException {
        writer.write(s);
    }

    public void writeParticipants(List<Participant> participants) throws IOException {
        write(participantsToString(participants));
    }

    public void writeGameMap(GameMap gameMap) throws IOException {
        write(gameMapToString(gameMap));
    }

    private String participantsToString(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getName)
                .map(name -> StringUtils.padLeftRight(name, LadderGameConfig.NAME_LENGTH))
                .reduce((nested, name) -> nested + " " + name)
                .orElse("") + "\n";
    }

    private String gameMapToString(GameMap gameMap) {
        StringBuilder sb = new StringBuilder();

        for (GameMapRow row : gameMap) {
            sb.append(rowToString(row));
            sb.append('\n');
        }

        return sb.toString();
    }

    private String rowToString(GameMapRow row) {
        StringBuilder sb = new StringBuilder();
        for (GameMapColumn col : row) {
            sb.append(col.getColumnValue());
        }

        return sb.toString();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
