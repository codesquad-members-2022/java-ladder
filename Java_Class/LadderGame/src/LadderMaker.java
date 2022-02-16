import java.util.List;
import java.util.Random;

public class LadderMaker {
    private final String VERTICAL = "|";
    private final String HORIZONTAL = "-----";
    private final String BLANKSPACE = "     ";

    private final Random random = new Random();
    private List<List<String>> ladder;
    private final int width;
    private final int height;

    public LadderMaker(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void makeLadder() {
        for (int row = 0; row < height; row++) {
            makeRow(row);
        }
    }

    private void makeRow(int row) {
        for (int column = 0; column < width; column++) {
            drawLine(row, column);
        }
    }

    private void drawLine(int row, int column) {
        if (column % 2 == 0) {
            ladder.get(row).add(VERTICAL);
            return;
        }
        if (random.nextBoolean()) {
            ladder.get(row).add(HORIZONTAL);
            return;
        }
        ladder.get(row).add(BLANKSPACE);
    }


    protected List<List<String>> getLadderList() {
        return ladder;
    }

}