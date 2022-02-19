package LadderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGame {

    private List<List<String>> arr;
    private int user;
    private int height;
    private static final String LADDERUNIT = "|";
    private static final String LINEUNIT = "-----";
    private static final String BLANK = "     ";
    private static final String LADDERPADDING = "    ";
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
        line.add(LADDERPADDING);
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
        line.add(LADDERUNIT);
    }

    private void createRandomLine(List<String> line) {
        Random rand = new Random();

        if (rand.nextBoolean() && isCreated) {
            line.add(LINEUNIT);
            isCreated = false;
            return ;
        }
        line.add(BLANK);
        isCreated = true;
    }
}
