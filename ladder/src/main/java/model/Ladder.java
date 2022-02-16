package model;

import java.util.Random;

import io.Output;

public class Ladder {

    private final int userCount;
    private final int ladderHeight;
    private static final String PILLAR = "|";
    private final String[] ladderUnit = {" ", "-", "-"};
    private final Random random = new Random(System.currentTimeMillis());

    public Ladder(int userCount, int ladderHigh) {
        this.userCount = userCount;
        this.ladderHeight = ladderHigh;
        createLadder();
    }

    private void createLadder() {
        String[][] ladder = new String[ladderHeight][ladderWidth()];
        for (int row = 0; row < ladder.length; row++) {
            ladderUnitArrangement(ladder, row);
        }
        printLadder(ladder);
    }

    private void ladderUnitArrangement(String[][] ladder, int row) {
        for (int col = 0; col < ladder[row].length; col++) {
            ladder[row][col] = ladderLineArrangement(col);
            isDuplicateLine(ladder, row, col);
        }
    }

    private String ladderLineArrangement(int col) {
        return isEven(col) ? PILLAR : ladderUnit[random.nextInt(ladderUnit.length)];
    }

    private void isDuplicateLine(String[][] ladder, int row, int col) {
        if (col > 1 && ladder[row][col - 2].equals(ladderUnit[1])) {
            ladder[row][col] = ladderUnit[0];
        }
    }

    private boolean isEven(int col) {
        return col % 2 == 0;
    }

    private int ladderWidth() {
        return userCount + (userCount - 1);
    }

    public void printLadder(String[][] ladder) {
        Output output = new Output();
        output.printLadder(ladder);
    }
}
