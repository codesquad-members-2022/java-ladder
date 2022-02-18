package domain.ladder;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int USER_LINE = 0;
    private static final int CONNECTION_LINE = 1;
    private static final int EMPTY_SPACE = -1;
    private List<Integer> row;


    public static Line createRandomStep(int width) {
        return new Line(width);
    }


    public int getPrev(int userPoint) {
        return row.get(userPoint - 1);
    }

    public int getNext(int userPoint) {
        return row.get(userPoint + 1);
    }

    public List<Integer> getLine() {
        return row;
    }

    private Line(int width) {
        row = createLadderRow(width);
    }

    private List<Integer> createLadderRow(int width) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            row.add(createElement(i, row));
        }
        return row;
    }

    private int createElement(int point, List<Integer> row) {
        if (point % 2 == 0) {
            return USER_LINE;
        }
        return createRandomStep(point, row);
    }

    private int createRandomStep(int point, List<Integer> row) {
        if (point == 1 || !isDoubleConnected(row.get(point - 2))) return createLineByRandom();
        return EMPTY_SPACE;
    }

    private int createLineByRandom() {
        return RandomUtil.getBoolean() ? CONNECTION_LINE : EMPTY_SPACE;
    }

    private boolean isDoubleConnected(int prev) {
        return prev == CONNECTION_LINE;
    }
}

