package main.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderPlane {

    private final List<LadderLine> lines;
    private final int height;
    private final int width;

    public LadderPlane(int height, int width) {
        this.height = height;
        this.width = width;
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

    public void move(Player player) {

        while (player.row() != height) {
            LadderLine line = lines.get(player.row());
            line.move(player);
        }

    }


}
