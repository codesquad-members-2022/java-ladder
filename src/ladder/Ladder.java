package src.ladder;

import java.util.Random;

public class Ladder {

    private static final String RAIL = "|";
    private static final String STEP = "-";
    private static final String BLANK = " ";
    private static final String NEW_LINE = "\n";
    private static final Random RANDOM = new Random();
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
            ladder[currentHeight][horizontalIndex] = RAIL;
            return;
        }
        if (RANDOM.nextBoolean()) {
            ladder[currentHeight][horizontalIndex] = STEP;
            return;
        }
        ladder[currentHeight][horizontalIndex] = BLANK;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ladder.length; i++) {
            appendSingleLine(i, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void appendSingleLine(int currentHeight, StringBuilder stringBuilder) {
        for (int i = 0; i < ladder[currentHeight].length; i++) {
            stringBuilder.append(ladder[currentHeight][i]);
        }
        stringBuilder.append(NEW_LINE);
    }


}

