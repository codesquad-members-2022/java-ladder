package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderRow> ladderRows = new ArrayList<>();

    Ladder(int width, int height) {
        initLadder(width, height);
    }

    private void initLadder (int width, int height) {
        IntStream.range(0, height)
                .mapToObj(row -> new LadderRow(width))
                .forEach(ladderRows::add);
    }

    public static Ladder makeForGame(int numberOfUsers, int height) {
        int width = 2 * numberOfUsers - 1;
        return new Ladder(width, height);
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
