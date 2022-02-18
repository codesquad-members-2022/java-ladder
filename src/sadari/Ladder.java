package sadari;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private List<List<String>> ladderList;
    private String step;
    private final int width;
    private final int height;
    private List<String> innerList;

    public Ladder(int width, int height) {
        this.width = width * 2 - 1;
        this.height = height;
        makeLadder(height);
    }

    public List<List<String>> makeLadder(int height) {
        ladderList = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            ladderList.add(checkLadderParts());
        }
        return ladderList;
    }

    public List<String> checkLadderParts() {
        innerList = new ArrayList<>();
        for (int column = 0; column < width; column++) {
            innerList.add(drawLines(column));
        }
        return innerList;
    }

    public String drawLines(int column) {
        Random rd = new Random();
        if (column % 2 == 0) {
            return step = "|";
        }
        if (rd.nextBoolean() && checkBlank(column)) {
            return step = "-----";
        }

        return step = "     ";
    }

    public boolean checkBlank (int column) {
        if (column == 1) {
            return true;
        }
        if ("     ".equals(innerList.get(column - 2))){
            return true;
        }
        return false;
    }
}
