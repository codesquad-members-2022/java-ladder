import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
    private final String VERTICAL = "|";
    private final String HORIZONTAL = "-----";
    private final String BLANKSPACE = "     ";

    private final Random random = new Random();
    private List<List<String>> ladder;
    private List<String> tempList;
    private final int width;
    private final int height;

    public LadderMaker(int nameCount, int height) {
        ladder = new ArrayList<>();
        this.width = nameCount * 2 - 1;
        this.height = height;
    }

    public void makeLadder() {
        for (int row = 0; row < height; row++) {
            makeRow(row);
        }
    }

    private void makeRow(int row) {
        tempList = new ArrayList<>();
        for (int column = 0; column < width; column++) {
            tempList.add(drawLine(row, column));
        }
        ladder.add(tempList);
    }

    private String drawLine(int row, int column) {
        if (column % 2 == 0) {
            return VERTICAL;
        }
        if (random.nextBoolean() && isBlank(column)) {
            return HORIZONTAL;
        }
        return BLANKSPACE;
    }

    private boolean isBlank(int column) {
        if (column == 1) {
            return true;
        }
        if (BLANKSPACE.equals(tempList.get(column - 2))) {
            return true;
        }
        return false;
    }

    protected List<List<String>> getLadderList() {
        return ladder;
    }
}