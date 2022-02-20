package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    static final String VERTICAL = "|";
    static final String HORIZONTAL = "-----";
    static final String BLANK_SPACE = "     ";
    static final Random random = new Random();
    private List<String> oneLine = new ArrayList<>();

    Line(int width) {
        for (int i = 0; i < width; i++) {
            oneLine.add(drawFigure(i));
        }
    }

    private String drawFigure(int column) {
        if (column % 2 == 0) {
            return VERTICAL;
        }
        if (random.nextBoolean() && isBlank(column)) {
            return HORIZONTAL;
        }
        return BLANK_SPACE;
    }

    private boolean isBlank(int column) {
        if (column == 1) {
            return true;
        }
        if (BLANK_SPACE.equals(oneLine.get(column - 2))) {
            return true;
        }
        return false;
    }

    public List<String> getLine() {
        return oneLine;
    }
}
