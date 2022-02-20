package application.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static application.domain.element.LadderElement.*;
import static application.util.RandomUtils.*;

public class Ladder {
    public static final int INTERVAL = 5;

    private List<Line> lines;
    private int height;
    private int width;

    public Ladder(int height, int width) {
        this.lines = new ArrayList<>();
        this.height = height;
        this.width = width;
        this.createLadder();
    }

    private void createLadder() {
        for (int row = 0; row < height; ++row) {
            lines.add(createLine());
        }
    }

    private Line createLine() {
        Line line = new Line();
        for (int col = 0; col < width; ++col) {
            line.addElement(nextDouble() * 10 < 5.5 && line.isValid(col) ? STEP : EMPTY);
        }
        return line;
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
