package ladder.model.ladder;

import ladder.model.Names;

public class Ladder {

    private final LadderLines ladderLines;

    public Ladder(LadderLines ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder getInstance() {
        return null;
    }

    public LadderLines getLadderLines(Names names, Height height) {
        return new LadderLines(names.size(), height);
    }
}
