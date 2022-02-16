import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;
    private List<Player> players;

    private Ladder() {
    }

    public static Ladder create(List<Player> players, int ladderMaxHeight) {
        Ladder ladder = new Ladder();
        ladder.players = players;
        ladder.lines = initLinesWithLadderMaxHeight(players.size(), ladderMaxHeight);
        return ladder;
    }

    private static List<Line> initLinesWithLadderMaxHeight(int playerCount, int ladderMaxHeight) {
        List<Line> lines = new ArrayList();
        for (int i = 0; i < ladderMaxHeight; i++) {
            lines.add(Line.createLineWithPlayerCount(playerCount));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void drawRandomLines() {
        for (Line line : lines) {
            drawRandomLine(line);
        }
    }

    public void drawRadder(int linePos, int radderPos) {
        lines.get(linePos).drawRadder(radderPos);
    }

    private void drawRandomLine(Line line) {
        for (int radderPos = 0; radderPos < players.size() - 1; radderPos++) {
            drawRandomRadder(line, radderPos);
        }
    }

    private void drawRandomRadder(Line line, int radderPos) {
        if (isRandomDraw())
            line.drawRadder(radderPos);
    }

    private boolean isRandomDraw() {
        return RandomUtils.nextBoolean();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
