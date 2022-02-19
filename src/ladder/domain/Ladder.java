package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int countOfPlayer;
    private final int height;
    private final List<Line> ladderArr = new ArrayList<>();

    public Ladder(int countOfPlayer, int height) {
        this.countOfPlayer = countOfPlayer;
        this.height = height;
        build();
    }

    private void build() {
        for (int i = 0; i < height; i++) {
            ladderArr.add(new Line(countOfPlayer));
        }
    }

    public List<Line> getLadderArr() {
        return ladderArr;
    }
}
