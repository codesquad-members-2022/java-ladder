package ladder.model.ladder;

import ladder.model.Counts;
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
        int number = names.size();
        return new LadderLines(Counts.of(number), height);
    }
}
