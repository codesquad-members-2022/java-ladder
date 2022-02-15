package dukcode.model;

import java.util.Random;

public class Ladder {

    private int height;
    private int numPlayer;
    private boolean[][] ladder;

    public Ladder() {}

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < height; ++line) {
            sb.append(getStringLine(line));
            sb.append("\n");
        }

        return new String(sb);
    }

    public String getStringLine(int line) {
        StringBuilder strLine = new StringBuilder("|");
        for (int step = 0; step < numPlayer -1; ++step) {
            strLine.append(ladder[line][step] ? "-" : " ");
            strLine.append("|");
        }

        return new String(strLine);
    }
}
