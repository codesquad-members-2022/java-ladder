package Ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    public Ladder(int playersCount, int maxLadderHeight) {
        this.ladder = new ArrayList<>();
        createLadder(playersCount, maxLadderHeight);
    }

    private void createLadder(int playerCount, int maxLadderHeight) {
        for (int i = 0; i < maxLadderHeight; i++) {
            Line line = new Line();
            line.createLine(playerCount);
            ladder.add(line);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Line line : ladder) {
            sb.append(line.toString() + "\n");
        }
        
        return sb.toString();
    }
}
