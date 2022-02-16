import java.util.Random;

public class Ladder {

    private static final Random random = new Random();

    private final Element[][] ladder;

    public Ladder(int width, int height) {
        this.ladder = new Element[height][width];
        initLadder();
    }

    private boolean isRail(int col) {
        return col % 2 == 0;
    }

    private boolean isOverlap(int row, int col) {
        return 2 < col && ladder[row][col - 2] != Element.EMPTY;
    }

    private Element createRandomStep() {
        int n = random.nextInt(2);
        return (n == 0) ? Element.EMPTY : Element.STEP;
    }

    private void fillLadderElement(int row, int col) {
        if (isRail(col)) {
            ladder[row][col] = Element.RAIL;
            return;
        }
        if (isOverlap(row, col)) {
            ladder[row][col] = Element.EMPTY;
            return;
        }
        ladder[row][col] = createRandomStep();
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
        for (Element col : ladder[row]) {
            sb.append(col.getValue());
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
