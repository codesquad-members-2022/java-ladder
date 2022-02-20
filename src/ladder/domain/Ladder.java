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
        createLines();
    }

    public int getCurrentPos(int indexOfPlayer) {
        // 현재 열과 -1칸 열을 검사하여 true 가 존재하면 그 칸으로 이동
        int currentPos = indexOfPlayer;
        for (Line line : ladderArr) {
            currentPos = updateCurrentPos(currentPos, line);
        }
        return currentPos;
    }

    private int updateCurrentPos(int currentPos, Line line) {
        if (currentPos < line.getPoints().size() && Boolean.TRUE.equals(line.getPoints().get(currentPos))) {
            return ++currentPos;
        }

        if (currentPos > 0 && Boolean.TRUE.equals(line.getPoints().get(currentPos - 1))) {
            return --currentPos;
        }
        return currentPos;
    }

    private void createLines() {
        for (int i = 0; i < height; i++) {
            ladderArr.add(new Line(countOfPlayer));
        }
    }

    public List<Line> getLadderArr() {
        return ladderArr;
    }
}
