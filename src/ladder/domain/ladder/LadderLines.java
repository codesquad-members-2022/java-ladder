package ladder.domain.ladder;

import ladder.utils.Count;
import ladder.domain.strategy.LadderLineFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(Count playerCounts, Height height) {
        this.ladderLines = LadderLineFactory.getLadderLines(playerCounts, height);
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(copy(this.ladderLines));
    }

    private List<LadderLine> copy(List<LadderLine> ladderLines){
        return new ArrayList<>(ladderLines);
    }
}
