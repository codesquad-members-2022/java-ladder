import java.util.List;
import java.util.Random;

public class LadderMaker {
    private final String VERTICAL = "|";
    private final String HORIZONTAL = "-----";
    private final String BLANKSPACE = "     ";

    private final Random random = new Random();
    private List<List<String>> ladder;

    public void makeLadder(int width, int height) {

        for (int i = 0; i < height; i++) {
            makeRow(width,height);
        }
    }


    private void makeRow(int width, int height) {
        for (int i = 0; i < width; i++) {
            drawLine(i,height);
        }
    }

    private void drawLine(int column, int height) {
        if (column % 2 == 0) {
            ladder.get(height).add(VERTICAL);
            return;
        }
        if (random.nextBoolean()) {
            ladder.get(height).add(HORIZONTAL);
            return;
        }
        ladder.get(height).add(BLANKSPACE);
    }

    protected List<List<String>> getLadderList() {
        return ladder;
    }

}