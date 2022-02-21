package ladder.domain.ladder;

import ladder.domain.strategy.LadderLineFactory;
import ladder.domain.user.Names;
import ladder.utils.Counts;

import java.util.ArrayList;
import java.util.List;


public class LadderLines {

    private LadderLines() {}

    private List<LadderLine> ladderLines;

    private static final LadderLines instance = new LadderLines();

    public static LadderLines getInstance() {
        if (instance == null) {
            return new LadderLines();
        }
        return instance;
    }

    LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> getLadderLines() {
        return new ArrayList<>(this.ladderLines);
    }

    LadderLines getLadderLines(Names names, Height height) {
        this.ladderLines = LadderLineFactory.getLadderLines(Counts.of(names.size()), height);
        return new LadderLines(this.ladderLines);
    }

    public int getResult(int index) {
        for (LadderLine ladderLine : ladderLines) {
            index = ladderLine.move(index);
        }
        return index;
    }
}
