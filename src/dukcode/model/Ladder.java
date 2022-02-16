package dukcode.model;

import java.util.Random;

public class Ladder {

    private int height;
    private int numPlayer;
    private int numSteps;
    private String[] namePlayers;
    private boolean[][] ladder;

    public Ladder() {}

    public String[] getNamePlayers() {
        String[] copyNamePlayers = new String[numPlayer];
        System.arraycopy(namePlayers, 0, copyNamePlayers, 0, numPlayer);
        return copyNamePlayers;
    }
    public int getNumPlayer() {
        return numPlayer;
    }
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

    public void init(String[] namePlayers, int height) {
        this.namePlayers = namePlayers;
        this.numPlayer = namePlayers.length;
        this.numSteps = namePlayers.length - 1;
        this.height = height;

        ladder = new boolean[height][numSteps];
        for (int line = 0; line < height; ++line) {
            initLine(line);
        }
    }

    private void initLine(int line) {
        Random rd = new Random();
        for (int step = 0; step < numSteps; ++step) {
            ladder[line][step] = rd.nextBoolean();
        }
    }

}
