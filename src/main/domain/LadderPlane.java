package main.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderPlane {

    private final List<LadderLine> lines;

    public LadderPlane(int height, int width) {
        this.lines = new ArrayList<>();

        for (int row = 0; row < height; row++) {
            lines.add(new LadderLine(width));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (LadderLine line : lines) {
            sb.append(line);
        }
        return sb.toString();
    }

}
