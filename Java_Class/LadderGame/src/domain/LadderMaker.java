package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    private final int WIDTH;
    private final int HEIGHT;
    private List<Line> ladder;


    public LadderMaker(int nameCount, int height) {
        ladder = new ArrayList<>();
        this.WIDTH = nameCount * 2 - 1;
        this.HEIGHT = height;
    }

    void make() {
        for (int row = 0; row < HEIGHT; row++) {
            ladder.add(new Line(WIDTH));
        }
    }

    protected List<Line> getLadderList() {
        return ladder;
    }
}