package application.domain.ladder;

import application.domain.element.LadderElement;

import java.util.ArrayList;
import java.util.List;

import static application.domain.element.LadderElement.*;

public class Line {
    private List<LadderElement> line;

    Line() {
        this.line = new ArrayList<>();
    }

    void addElement(LadderElement e) {
        line.add(e);
    }

    boolean isValid(int col) {
        return col == 0 || line.get(col - 1) != STEP;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderElement element : line) {
            sb.append(RAIL).append(element);
        }
        sb.append(RAIL).append('\n');
        return sb.toString();
    }
}
