package domain;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String USER_LINE = "|";
    private static final String CONNECTION_LINE = "-----";
    private static final String EMPTY_SPACE = "     ";
    private List<String> row;


    public static Line createRandomStep(int width) {
        return new Line(width);
    }

    private Line(int width) {
        row = createLadderRow(width);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        row.forEach(element -> sb.append(element));
        return sb.toString();
    }

    private List<String> createLadderRow(int width) {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            row.add(createElement(i, row));
        }
        return row;
    }

    private String createElement(int point, List<String> row) {
        if (point % 2 == 0) {
            return USER_LINE;
        }
        return createRandomStep(point, row);
    }

    private String createRandomStep(int point, List<String> row) {
        if (point == 1 || !isDoubleConnected(row.get(point - 2))) return createLineByRandom();
        return EMPTY_SPACE;
    }

    private String createLineByRandom() {
        return RandomUtil.getBoolean() ? CONNECTION_LINE : EMPTY_SPACE;
    }

    private boolean isDoubleConnected(String prev) {
        return prev.equals(CONNECTION_LINE);
    }
}

