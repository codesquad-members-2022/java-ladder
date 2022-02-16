package ladder.model.ladder;

import ladder.model.strategy.LadderLineFactory;

import java.util.List;
import java.util.Objects;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(List<LadderLine> ladderLines, int playerCounts, Height height) {
        validate(ladderLines);
        this.ladderLines = LadderLineFactory.getLadderLines(playerCounts, height);
    }

    private void validate(List<LadderLine> ladderLines) {
        Objects.requireNonNull(ladderLines);
    }
}
