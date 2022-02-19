package ladder.domain.ladder;

import ladder.domain.user.Names;
import ladder.system.Configuration;
import ladder.utils.Counts;

import java.util.List;

public class Ladder {

    private static Ladder instance = new Ladder();
    private LadderLines ladderLines;

    private Ladder() {
        this.ladderLines = Configuration.ladderLines;
    }

    private Ladder(LadderLines ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder getInstance() {
        if (instance == null) {
            return new Ladder();
        }
        return instance;
    }

    public Ladder getLadder(Names names, Height height) {
        int number = names.size();
        LadderLines ladderLines = this.ladderLines.getLadderLines(Counts.of(number), height);
        return new Ladder(ladderLines);
    }

    public LadderLines getLadderLines(){
        List<LadderLine> ladderLines = this.ladderLines.getLadderLines();
        return this.ladderLines.getLadderLines(ladderLines);
    }
}
