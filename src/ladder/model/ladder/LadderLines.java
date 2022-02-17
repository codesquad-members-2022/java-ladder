package ladder.model.ladder;

import ladder.model.strategy.LadderLineFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(int playerCounts, Height height) {
        this.ladderLines = LadderLineFactory.getLadderLines(playerCounts, height);
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(new ArrayList<>(ladderLines));
    }
}
