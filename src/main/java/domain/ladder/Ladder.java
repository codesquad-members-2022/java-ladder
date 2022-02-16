package domain.ladder;

import java.util.List;

public class Ladder {

    private final List<List<LadderElement>> ladderElements;

    Ladder(List<List<LadderElement>> ladderFrame) {
        this.ladderElements = ladderFrame;
    }

    public LadderElement getLadderElement(int column, int row) {
        return ladderElements.get(row).get(column);
    }

    void setLadderElement(int column, int row, LadderElement ladderElement) {
        ladderElements.get(row).set(column, ladderElement);
        return;
    }

    public int width() {
        return ladderElements.get(0).size();
    }

    public int height() {
        return ladderElements.size();
    }

}
