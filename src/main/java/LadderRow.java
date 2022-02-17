import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {

    private static final Random random = new Random();

    private final List<LadderElement> row;

    public LadderRow(int width) {
        row = new ArrayList<>();
        for (int col = 0; col < width; col++) {
            row.add(generateLadderElement(col));
        }
    }

    private boolean isRail(int col) {
        return col % 2 == 0;
    }

    private boolean isOverlap(int col) {
        return 2 < col && row.get(col - 2) != LadderElement.EMPTY;
    }

    private LadderElement createRandomStep() {
        int n = random.nextInt(2);
        return (n == 0) ? LadderElement.EMPTY : LadderElement.STEP;
    }

    private LadderElement generateLadderElement(int col) {
        if (isRail(col)) {
            return LadderElement.RAIL;
        }
        if (isOverlap(col)) {
            return LadderElement.EMPTY;
        }
        return createRandomStep();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderElement col : row) {
            sb.append(col.getValue());
        }
        return sb.toString();
    }
}
