package domain.ladder;

public class Ladder {

    private final LadderElement[][] ladderElements;

    public Ladder(LadderElement[][] ladderElements) {
        this.ladderElements = ladderElements;
    }

    public LadderElement[][] getLadderElements() {
        return ladderElements;
    }
}
