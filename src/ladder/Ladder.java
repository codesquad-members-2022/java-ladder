package src.ladder;

import java.util.Random;

public class Ladder {

    private final String verticalBar = "|";
    private final String horizontalBar = "-";
    private final String blank = " ";
    private final Random random = new Random();
    private String[][] ladder;

    public Ladder(int peopleCount, int ladderHeight) {
        this.ladder = new String[ladderHeight][peopleCount * 2 - 1];
        createLadder(peopleCount, ladderHeight);
    }

    private void createLadder(int peopleCount, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            insertSingleLine(i);
        }
    }

    private void insertSingleLine(int currentHeight) {
        for (int i = 0; i < ladder[currentHeight].length; i++) {
            insertLadderBar(currentHeight, i);
        }
    }

    private void insertLadderBar(int currentHeight, int horizontalIndex) {
        if (horizontalIndex % 2 == 0) {
            ladder[currentHeight][horizontalIndex] = verticalBar;
            return;
        }
        if (random.nextBoolean()) {
            ladder[currentHeight][horizontalIndex] = horizontalBar;
            return;
        }
        ladder[currentHeight][horizontalIndex] = blank;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                stringBuilder.append(ladder[i][j]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}

