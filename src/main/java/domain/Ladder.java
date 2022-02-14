package domain;

import java.util.Arrays;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < (2 * this.playersCount) - 1; j++) {
                sb.append(ladder[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
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
