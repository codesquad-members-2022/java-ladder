package domain.ladder;

import java.util.List;

public class LadderRow {

    private List<LadderElement> ladderElements;

    LadderRow(List<LadderElement> ladderRowFrame) {
        this.ladderElements = ladderRowFrame;
    }

    public LadderElement getLadderElement(int column) {
        return ladderElements.get(column);
    }

    public void drawLadderElement(int column, LadderElement ladderElement) {
        ladderElements.set(column, ladderElement);
    }

    public int width() {
        return ladderElements.size();
    }
}
