package Ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladderInstance;

    public Ladder(int playersCount, int maxLadderHeight) {
        this.ladderInstance = getLadder(playersCount, maxLadderHeight);
    }

    private List<Line> getLadder(int playersCount, int maxLadderHeight) {
        if (ladderInstance == null) {
            createLadder(playersCount, maxLadderHeight);
        }
        return ladderInstance;
    }

    private void createLadder(int playerCount, int maxLadderHeight) {
        this.ladderInstance = new ArrayList<>();

        for (int i = 0; i < maxLadderHeight; i++) {
            Line line = new Line();
            line.createLine(playerCount);
            ladderInstance.add(line);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Line line : ladderInstance) {
            sb.append(line.toString() + "\n");
        }
        
        return sb.toString();
    }
}
