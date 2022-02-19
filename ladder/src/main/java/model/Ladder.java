package model;

import java.util.ArrayList;
import java.util.List;

import io.Output;

public class Ladder {

    private final int userCount;
    private final int ladderHeight;
    private final List<Line> ladder = new ArrayList<>();


    public Ladder(int userCount, int ladderHeight) {
        this.userCount = userCount;
        this.ladderHeight = ladderHeight;
    }

    public void createLadder() {
        for (int lineCount = 0; lineCount < this.ladderHeight; lineCount++) {
            Line line = new Line(this.userCount);
            this.ladder.add(line);
        }
    }

    public void printLadder() {
        Output output = new Output();
        output.printLadder(ladder);
    }
}
