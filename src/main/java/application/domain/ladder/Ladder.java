package application.domain.ladder;

import application.domain.element.LadderElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static application.domain.element.LadderElement.*;
import static application.util.RandomUtils.*;

public class Ladder {
    public static final int INTERVAL = 5;

    private final List<Line> lines;
    private final int height;
    private final int width;

    public Ladder(int height, int width) {
        this.lines = new ArrayList<>();
        this.height = height;
        this.width = width;
    }

    public void createLadder() {
        for (int row = 0; row < height; ++row) {
            lines.add(createLine());
        }
    }

    private Line createLine() {
        Line line = new Line();
        for (int col = 0; col < width; ++col) {
            line.addElement(createElement(line, col));
        }
        return line;
    }

    private LadderElement createElement(Line line, int col) {
        return nextDouble() * 10 < 5.5 && line.isValid(col) ? STEP : EMPTY;
    }

    public String output() {
        return lines.stream().map(Line::output).collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
