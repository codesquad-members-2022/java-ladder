package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private static final String LADDER_VERTICAL_LINE_LEFT = "  |";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_BLANK = "     ";

    private static Ladder ladderInstance;
    private static int playersCount;
    private static int maxLadderHeight;
    private static List<List<String>> ladder;
    private static Random random;

    private Ladder(int playersCount, int maxLadderHeight) {
        this.playersCount = playersCount;
        this.maxLadderHeight = maxLadderHeight;
        this.ladder = new ArrayList<>();
        this.random = new Random();
    }

    public static Ladder getLadder(int playersCount, int maxLadderHeight) {
        if (ladderInstance == null) {
            ladderInstance = new Ladder(playersCount, maxLadderHeight);
            generateLadder();
        }
        return ladderInstance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (List<String> row : ladder) {
            sb.append(rowString(row) + "\n");
        }

        return sb.toString();
    }

    private static String rowString(List<String> row) {
        StringBuilder sb = new StringBuilder();

        for (String value : row) {
            sb.append(value);
        }

        return sb.toString();
    }

    private static int getWidth() {
        return (2 * playersCount) - 1;
    }

    public static void generateLadder() {
        for (int i = 0; i < maxLadderHeight; i++) {
            ladder.add(new ArrayList<>());
        }
        initLadder();
    }

    private static void initLadder() {
        for (int i = 0; i < maxLadderHeight; i++) {
            initLadderColumn(i);
        }
    }

    private static void initLadderColumn(int i) {
        for (int j = 0; j < getWidth(); j++) {
            ladder.get(i).add(setElement(j, rowString(ladder.get(i))));
        }
    }

    private static String setElement(int j, String rowString) {
        if (j % 2 == 0 && j == 0) {
            return LADDER_VERTICAL_LINE_LEFT;
        }
        if (j % 2 == 0) {
            return LADDER_VERTICAL_LINE;
        }
        if (getRandomBoolean() && !rowString.contains(LADDER_HORIZONTAL_LINE)) {
            return LADDER_HORIZONTAL_LINE;
        }
        return LADDER_BLANK;
    }

    private static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
