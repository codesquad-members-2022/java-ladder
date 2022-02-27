package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final int ladderWidth;
    private final int ladderHeight;
    private final List<Line> ladders;


    public Ladder(int ladderHeight, int ladderWidth) {
        this.ladderHeight = ladderHeight;
        this.ladderWidth = ladderWidth;
        ladders = initLadder();
    }

    public int getLadderSize() {
        return ladderHeight;
    }

    public List<Line> getLadders() {
        return Collections.unmodifiableList(ladders);
    }

    public int move(int rowNumber, int userPoint) {
        Line line = ladders.get(rowNumber);
        if (userPoint == 0) {
            return canMoveRight(line, userPoint);
        }
        if (userPoint == ladderWidth-1) {
            return canMoveLeft(line, userPoint);
        }
        return canMoveLeft(line, userPoint) + canMoveRight(line, userPoint);

    }

    private int canMoveLeft(Line line, int userPoint) {
        if (line.getPrev(userPoint) == 1) return -2;
        return 0;
    }

    private int canMoveRight(Line line, int userPoint) {
        if (line.getNext(userPoint) == 1) return 2;
        return 0;
    }

    private List<Line> initLadder() {
        List<Line> result = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            result.add(Line.createRandomStep(ladderWidth));
        }
        return result;
    }


}
