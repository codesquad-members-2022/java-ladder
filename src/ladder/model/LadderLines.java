package ladder.model;

import java.util.List;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(List<LadderLine> ladderLines, int nameCount, Height height) {
        this.ladderLines = LadderLineFactory.getLadderLines(nameCount, height);
    }
}
