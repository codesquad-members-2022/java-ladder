import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {

    private static final Random random = new Random();

    private final List<Element> row;

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
        return 2 < col && row.get(col - 2) != Element.EMPTY;
    }

    private Element createRandomStep() {
        int n = random.nextInt(2);
        return (n == 0) ? Element.EMPTY : Element.STEP;
    }

    private Element generateLadderElement(int col) {
        if (isRail(col)) {
            return Element.RAIL;
        }
        if (isOverlap(col)) {
            return Element.EMPTY;
        }
        return createRandomStep();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Element col : row) {
            sb.append(col.getValue());
        }
        return sb.toString();
    }
}
