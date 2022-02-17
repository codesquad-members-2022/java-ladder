package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;
    private int maxLength;

    private Line() {
    }

    public static Line createLineWithPlayerCount(int count) {
        Line line = new Line();
        line.checkCount(count);
        line.maxLength = count;
        line.points = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            line.points.add(false);
        }
        return line;
    }

    private void checkCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count가 정상 범위를 넘었습니다.");
        }
    }

    public boolean isLadder(int ladderPos) {
        checkPos(ladderPos);
        return points.get(ladderPos);
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void drawLadder(int ladderPos) {
        checkPos(ladderPos);
        if (isDrawLadder(ladderPos)) {
            points.set(ladderPos, true);
        }
    }

    private boolean isDrawLadder(int ladderPos) {
        if (ladderPos == 0) {
            return checkCur(ladderPos) && checkRight(ladderPos);
        }
        return checkLeft(ladderPos) && checkCur(ladderPos) && checkRight(ladderPos);
    }

    private void checkPos(int point) {
        if (point < 0 || point >= maxLength - 1) {
            throw new IllegalArgumentException("pos가 정상 범위를 넘었습니다.");
        }
    }

    private boolean checkLeft(int ladderPos) {
        return !points.get(ladderPos - 1);
    }

    private boolean checkRight(int ladderPos) {
        return !points.get(ladderPos + 1);
    }

    private boolean checkCur(int ladderPos) {
        return !points.get(ladderPos);
    }


}
