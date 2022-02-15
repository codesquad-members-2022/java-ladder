import java.util.Random;

public class LadderMaker {
    private final Random random = new Random();
    private String[][] ladder;

    protected void makeLadder(int[] inputArray) {
        ladder = new String[inputArray[1]][inputArray[0] * 2 - 1];
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

    protected String[][] getLadderArray() {
        return ladder;
    }
}