package ladder.domain.ladder;

import ladder.domain.strategy.LadderLineFactory;
import ladder.utils.Count;

import java.util.Collections;
import java.util.List;

import static ladder.utils.CopyUtils.copy;

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

    private LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    LadderLines getLadderLines(Count playerCounts, Height height) {
        this.ladderLines = LadderLineFactory.getLadderLines(playerCounts, height);
        return new LadderLines(this.ladderLines);
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(copy(this.ladderLines));
    }

    LadderLines getLadderLines(List<LadderLine> ladderLines){
        return new LadderLines(ladderLines);
    }

    public int getResult(int index) {
        for (LadderLine ladderLine : ladderLines) {
            index = ladderLine.trace(index);
        }
        return index;
    }
}
