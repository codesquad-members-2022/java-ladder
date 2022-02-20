package ladder.domain.ladder;

import ladder.domain.user.Names;
import ladder.system.Configuration;
import ladder.utils.Counts;

import java.util.List;


public class Ladder {


    private Ladder (){};
    private LadderLines ladderLines;

    private static final Ladder instance = new Ladder();
    public Ladder(LadderLines ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder getInstance() {
        if (instance == null) {
            return new Ladder();
        }
        return instance;
    }

    public Ladder getLadder(Names names, Height height) {
        LadderLines ladderLines = this.ladderLines.getLadderLines(names, height);
        return new Ladder(ladderLines);
    }

    public LadderLines getLadderLines(Names names, Height height) {
        return new LadderLines(names, height);
    }
}
