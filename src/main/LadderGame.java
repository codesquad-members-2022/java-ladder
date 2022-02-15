package main;

import java.util.List;
import main.util.LadderUtil;

public class LadderGame {

    private final List<String> names;
    private final int numLadder;

    private int height;
    private int width;
    private List<List<LadderElement>> map;

    public LadderGame(List<String> names, int numLadder) {
        this.names = names;
        this.numLadder = numLadder;
    }

    public void createMap() {
        height = getHeight();
        width = getWidth();
        map = LadderUtil.create2DList(height, width);

        changePlane();
    }

    public List<String> getNames() {
        return names;
    }

    public List<List<LadderElement>> getMap() {
        return map;
    }

    private int getWidth() {
        return 2 * names.size() - 1;
    }

    private int getHeight() {
        return numLadder;
    }

    private void changePlane() {
        for (int row = 0; row < height; row++) {
            changeLine(row);
        }
    }

    private void changeLine(int row) {
        boolean next = true;

        for (int col = 0; col < width; col++) {
            next = changeElement(row, col, next);
        }
    }

    private boolean changeElement(int row, int col, boolean prev) {
        boolean next = prev;

        if (col % 2 == 0) {
            this.map.get(row).set(col, LadderElement.VERTICAL);
        }
        if (col % 2 != 0) {
            next = changeSpace(row, col, prev);
        }
        return next;
    }

    private boolean changeSpace(int row, int col, boolean next) {
        boolean rand = LadderUtil.nextBoolean();

        if (next && rand) {
            this.map.get(row).set(col, LadderElement.HORIZONTAL);
        }
        if (!next || !rand) {
            this.map.get(row).set(col, LadderElement.BLANK);
        }
        return !next || !rand;
    }

}
