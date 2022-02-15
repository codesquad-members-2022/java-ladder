package domain.ladder;

public class Ladder {

    private LadderElement[][] ladderElements;

    public Ladder(LadderElement[][] ladderElements) {
        this.ladderElements = ladderElements;
    }

    public int width() {
        return ladderElements[0].length;
    }

    public int height() {
        return ladderElements.length;
    }

    public LadderElement[][] getLadderElements() {
        return ladderElements;
    }
}
