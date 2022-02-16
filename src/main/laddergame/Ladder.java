package main.laddergame;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String BLANK = "     ";
    private static final String RUNG = "-----";
    private static final String RAIL = "|";

    private final int width;
    private final int height;
    private final List<List<String>> ladderArr = new ArrayList<>();
    private boolean previous = false;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        createLadder();
    }

    private void createLadder() {
        for (int i = 0; i < height; i++) {
            ladderArr.add(generate(i));
        }
    }

    private ArrayList<String> generate(int h) {
        ArrayList<String> result = new ArrayList<>();
        for (int j = 0; j < width; j++) {
            result.add(randomlyAddRung(j));
        }
        return result;
    }

    private String randomlyAddRung(int j) {
        if (j % 2 == 0) {
            return RAIL;
        }
        return (Math.random() > 0.5 && !previous) ? addRung() : addBlank();
    }

    private String addRung() {
        previous = true;
        return RUNG;
    }

    public List<List<String>> getLadderArr() {
        return ladderArr;
    }

    private String addBlank() {
        previous = false;
        return BLANK;
    }
}
