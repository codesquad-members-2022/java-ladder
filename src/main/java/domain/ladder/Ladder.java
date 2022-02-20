package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderRow> ladderRows = new ArrayList<>();

    public Ladder(int numberOfUsers, int height) {
        initLadder(numberOfUsers, height);
    }

    private void initLadder (int numberOfUsers, int height) {
        IntStream.range(0, height)
                .mapToObj(row -> new LadderRow(numberOfUsers))
                .forEach(ladderRows::add);
    }

    public LadderElement getLadderElement(int column, int row) {
        LadderRow ladderRow = ladderRows.get(row);
        return ladderRow.getLadderElement(column);
    }

    public int width() {
        return ladderRows.get(0).width();
    }

    public int height() {
        return ladderRows.size();
    }
}
