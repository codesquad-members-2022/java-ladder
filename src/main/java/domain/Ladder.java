package domain;

import java.util.Random;

public class Ladder {

    private int playersCount;
    private int maxLadderHeight;
    private String[][] ladder;

    public Ladder(int playersCount, int maxLadderHeight) {
        this.playersCount = playersCount;
        this.maxLadderHeight = maxLadderHeight;
        this.ladder = new String[this.maxLadderHeight][(2 * this.playersCount) - 1];
    }

    public void generateLadder() {
        initEvenColumn();
        initOddColumn();
    }

    private void initEvenColumn() {
        for (int i = 0; i < this.maxLadderHeight; i++) {
            for (int j = 0; j < (2 * this.playersCount) - 1; j = j + 2) {
                ladder[i][j] = "|";
            }
        }
    }

    private void initOddColumn() {
        for (int i = 0; i < this.maxLadderHeight; i++) {
            for (int j = 1; j < (2 * this.playersCount) - 1; j = j + 2) {
                ladder[i][j] = " ";
                if (getRandomBoolean()) {
                    ladder[i][j] = "-";
                }
            }
        }
    }

    private boolean getRandomBoolean() {
        return new Random().nextBoolean();
    }
}
