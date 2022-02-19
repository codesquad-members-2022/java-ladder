package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladder;

    public Ladder(int width, int height) {
        this.ladder = new ArrayList<>();
        initLadder(width, height);
    }

    private void initLadder(int width, int height) {
        for (int row = 0; row < height; row++) {
            ladder.add(new LadderRow(width));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow ladderRow : ladder) {
            sb.append(ladderRow.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
