import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int playerCount;
    private int ladderMaxHeight;
    private List<Line> lines;

    private Ladder() {
    }

    public static Ladder create(int playerCount, int ladderMaxHeight) {
        Ladder ladder = new Ladder();
        ladder.playerCount = playerCount;
        ladder.ladderMaxHeight = ladderMaxHeight;
        ladder.lines = initLinesWithLadderMaxHeight(playerCount, ladderMaxHeight);
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
        for (int radderPos = 0; radderPos < playerCount - 1; radderPos++) {
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
}
