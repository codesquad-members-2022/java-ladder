package domain.ladder;

import java.util.List;

public class Ladder {

    private final List<LadderRow> ladderRows;

    Ladder(List<LadderRow> ladderFrame) {
        this.ladderRows = ladderFrame;
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
