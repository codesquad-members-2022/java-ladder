package app.jinan159.ladder.view;

import app.jinan159.ladder.LadderGame;
import app.jinan159.ladder.domain.Participant;
import app.jinan159.ladder.domain.gamemap.GameMap;

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
        write(gameMap.gameMapToString());
    }

    private String participantsToString(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getName)
                .map(this::padName)
                .reduce((nested, name) -> nested + " " + name)
                .orElse("") + "\n";
    }

    private String padName(String name) {
        if (name.length() == LadderGame.MAX_NAME_LENGTH) return name;

        int paddingSize = LadderGame.MAX_NAME_LENGTH - name.length();
        int padCount1 = paddingSize / 2;
        int padCount2 = paddingSize - padCount1;

        if (padCount1 > padCount2) {
            return getPad(padCount1) + name + getPad(padCount2);
        }

        return getPad(padCount2) + name + getPad(padCount1);
    }

    private String getPad(int count) {
        return " ".repeat(Math.max(0, count));
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
