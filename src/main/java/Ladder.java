import java.util.Random;

public class Ladder {

    private static final String RAIL = "|";
    private static final String STEP = "-----";
    private static final String EMPTY = "     ";
    private static final Random random = new Random();

    private final String[][] ladder;

    public Ladder(int entry, int height) {
        int width = entry + (entry - 1);
        this.ladder = new String[height][width];
        initLadder();
    }

    private boolean isRail(int col) {
        return col % 2 == 0;
    }

    private String createRandomStep() {
        int n = random.nextInt(2);
        return (n == 0) ? EMPTY : STEP;
    }

    private void fillLadderElement(int row, int col) {
        ladder[row][col] = (isRail(col)) ? RAIL : createRandomStep();
    }

    private void initLadderRow(int row) {
        for (int col = 0; col < ladder[row].length; col++) {
            fillLadderElement(row, col);
        }
    }

    private void initLadder() {
        for (int row = 0; row < ladder.length; row++) {
            initLadderRow(row);
        }
    }

    private StringBuilder appendLadderRow(StringBuilder sb, int row) {
        for (String col : ladder[row]) {
            sb.append(col);
        }
        sb.append("\n");
        return sb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < ladder.length; row++) {
            appendLadderRow(sb, row);
        }
        return sb.toString();
    }
}
