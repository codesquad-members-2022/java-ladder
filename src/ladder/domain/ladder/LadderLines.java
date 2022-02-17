package ladder.domain.ladder;

import ladder.domain.strategy.LadderLineFactory;
import ladder.utils.Count;

import java.util.Collections;
import java.util.List;

import static ladder.utils.CopyUtils.copy;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(Count playerCounts, Height height) {
        this.ladderLines = LadderLineFactory.getLadderLines(playerCounts, height);
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(copy(this.ladderLines));
    }
}
