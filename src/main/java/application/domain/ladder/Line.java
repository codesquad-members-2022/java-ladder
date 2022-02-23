package application.domain.ladder;

import application.domain.element.LadderElement;

import java.util.ArrayList;
import java.util.List;

import static application.domain.element.LadderElement.*;

public class Line {
    private final List<LadderElement> line;

    Line() {
        this.line = new ArrayList<>();
    }

    void addElement(LadderElement e) {
        line.add(e);
    }

    boolean isValid(int col) {
        return col == 0 || line.get(col - 1) != STEP;
    }

    LadderElement getElement(int col) {
        return col >= 0 && col < line.size() ? line.get(col) : EMPTY;
    }

    public String output() {
        StringBuilder sb = new StringBuilder();
        for (LadderElement element : line) {
            sb.append(RAIL.output()).append(element.output());
        }
        sb.append(RAIL.output()).append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + line +
                '}';
    }
}
