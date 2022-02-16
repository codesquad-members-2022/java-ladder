package dukcode.model;

import java.util.Random;

public class Ladder {

    private int height;
    private int numPlayer;
    private boolean[][] ladder;

    public Ladder() {}

    public int getHeight() {
        return height;
    }

    public int getNumSteps() {
        return numPlayer - 1;
    }

    public boolean[][] getLadder() {
        boolean[][] copyLadder = new boolean[height][numPlayer - 1];
        for (int line = 0; line < height; ++line) {
            System.arraycopy(ladder[line], 0, copyLadder[line], 0, ladder[line].length);
        }

        return copyLadder;
    }

    public void init(int numPlayer, int height) {
        this.numPlayer = numPlayer;
        this.height = height;

        ladder = new boolean[height][numPlayer - 1];
        for (int line = 0; line < height; ++line) {
            initLine(line);
        }
    }

    private void initLine(int line) {
        Random rd = new Random();
        for (int step = 0; step < numPlayer - 1; ++step) {
            ladder[line][step] = rd.nextBoolean();
        }
    }

}
