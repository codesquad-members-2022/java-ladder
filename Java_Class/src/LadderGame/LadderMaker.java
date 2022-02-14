package LadderGame;

import java.util.Random;

public class LadderMaker {
    Random random = new Random();
    String[][] ladder;

    public void makeLadder(int[] inputArray) {
        ladder = new String[inputArray[1]][inputArray[0]];

        for (int row = 0; row < ladder.length; row++) {
               makeRow(row);
        }
    }

    private void makeRow(int row) {
        for (int column = 0; column < ladder[0].length; column++) {
            drawLine(row, column);
        }
    }
    private void drawLine(int row, int column) {
        if (column % 2 == 0) {
            ladder[row][column] = "|";
            return;
        }
        if (random.nextBoolean()) {
            ladder[row][column] = "-";
            return;
        }
        ladder[row][column] = " ";
    }

    public String[][] getLadder() {
        return ladder;
    }
}