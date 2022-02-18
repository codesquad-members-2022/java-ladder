package LadderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGame {

    private List<List<String>> arr;
    private int user;
    private int height;
    private static final String LADDER_UNIT = "|";
    private static final String LINE_UNIT = "-----";
    private static final String BLANK = "     ";
    private static final String LADDER_PADDING = "    ";
    private static boolean isCreated = true;

    LadderGame() {

    }

    public void init(int user, int height) {
        this.user = user;
        this.height = height;
        build();
    }

    public void build() {
        arr = new ArrayList<>();

        for (int row = 0; row < height; row++) {
            isCreated = true;
            List<String> line = new ArrayList<>();

            arr.add(getLadderLine(line));
        }
        Output.printLadderGame(arr);
    }

    private List<String> getLadderLine(List<String> line) {
        int width = user * 2 - 1;
        line.add(LADDER_PADDING);
        for (int col = 0; col < width; col++) {
            createUnit(col, line);
        }
        return line;
    }

    private void createUnit(int col, List<String> line) {
        if (col % 2 == 1) {
            createRandomLine(line);
            return ;
        }
        line.add(LADDER_UNIT);
    }

    private void createRandomLine(List<String> line) {
        Random rand = new Random();

        if (rand.nextBoolean() && isCreated) {
            line.add(LINE_UNIT);
            isCreated = false;
            return ;
        }
        line.add(BLANK);
        isCreated = true;
    }
}
