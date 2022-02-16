import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
    private final String VERTICAL = "|";
    private final String HORIZONTAL = "-----";
    private final String BLANK_SPACE = "     ";
    private final Random random = new Random();
    private final int WIDTH;
    private final int HEIGHT;
    private List<String> ladder;
    private List<String> tempList;


    public LadderMaker(int nameCount, int height) {
        ladder = new ArrayList<>();
        this.WIDTH = nameCount * 2 - 1;
        this.HEIGHT = height;
    }

    public void make() {
        for (int row = 0; row < HEIGHT; row++) {
            makeRow();
        }
    }

    private void makeRow() {
        tempList = new ArrayList<>();
        for (int column = 0; column < WIDTH; column++) {
            tempList.add(drawLine(column));
        }
        ladder.add(String.join("",tempList));
    }

    private String drawLine(int column) {
        if (column % 2 == 0) {
            return VERTICAL;
        }
        if (random.nextBoolean() && isBlank(column)) {
            return HORIZONTAL;
        }
        return BLANK_SPACE;
    }

    private boolean isBlank(int column) {
        if (column == 1) {
            return true;
        }
        if (BLANK_SPACE.equals(tempList.get(column - 2))) {
            return true;
        }
        return false;
    }

    protected List<String> getLadderList() {
        return ladder;
    }
}