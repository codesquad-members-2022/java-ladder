import java.util.Random;

public class Ladder {

    private static final String PILLAR = "|";
    private static final String LINE = "-";
    private static final String EMPTY = " ";
    private static final Random random = new Random();

    private final String[][] ladder;

    public Ladder(int entry, int height) {
        int width = entry + (entry - 1);
        this.ladder = new String[height][width];
        initLadder();
    }

    private boolean isPillar(int col) {
        return col % 2 == 0;
    }

    private String createRandomLine() {
        int n = random.nextInt(2);
        return (n == 0) ? EMPTY : LINE;
    }

    private void fillLadderElement(int row, int col) {
        if (isPillar(col)) {
            ladder[row][col] = PILLAR;
        } else {
            ladder[row][col] = createRandomLine();
        }
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
