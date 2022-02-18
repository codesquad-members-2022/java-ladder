package domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderRow> ladderRows;

    Ladder(int width, int height) {
        this.ladderRows = initLadder(width, height);
    }

    private List<LadderRow> initLadder (int width, int height) {
        return IntStream.range(0, height)
                        .mapToObj(row -> new LadderRow(width))
                        .collect(Collectors.toList());
    }

    public LadderElement getLadderElement(int column, int row) {
        LadderRow ladderRow = ladderRows.get(row);
        return ladderRow.getLadderElement(column);
    }

    void drawLadderElement(int column, int row, LadderElement ladderElement) {
        LadderRow ladderRow = ladderRows.get(row);
        ladderRow.drawLadderElement(column, ladderElement);
    }

    public int width() {
        return ladderRows.get(0).width();
    }

    public int height() {
        return ladderRows.size();
    }

}
