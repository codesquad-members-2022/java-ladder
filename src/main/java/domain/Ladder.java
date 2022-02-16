package domain;

import java.util.Random;

public class Ladder {

    private static final char LADDER_VERTICAL_LINE = '|';
    private static final char LADDER_HORIZONTAL_LINE = '-';
    private static final char LADDER_BLANK = ' ';

    private static Ladder ladderInstance;
    private static int playersCount;
    private static int maxLadderHeight;
    private static char[][] ladder;
    private static Random random;

    private Ladder(int playersCount, int maxLadderHeight) {
        this.playersCount = playersCount;
        this.maxLadderHeight = maxLadderHeight;
        this.ladder = new char[this.maxLadderHeight][getWidth()];
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

        for (int i = 0; i < ladder.length * getWidth(); i++) {
            int row = i / ladder[0].length;
            int col = i % ladder[0].length;
            sb.append(ladder[row][col]);
            sb.append(newLine(ladder[0].length, col));
        }

        return sb.toString();
    }

    private static String newLine(int height, int col) {
        if (col == height - 1) {
            return "\n";
        }
        return "";
    }

    private static int getWidth() {
        return (2 * playersCount) - 1;
    }

    public static void generateLadder() {
        initLadder();
    }

    private static void initLadder() {
        for (int i = 0; i < maxLadderHeight; i++) {
            initLadderColumn(i);
        }
    }

    private static void initLadderColumn(int i) {
        for (int j = 0; j < getWidth(); j++) {
            ladder[i][j] = setElement(j);
        }
    }

    private static char setElement(int j) {
        if (j % 2 == 0) {
            return LADDER_VERTICAL_LINE;
        }
        if (getRandomBoolean()) {
            return LADDER_HORIZONTAL_LINE;
        }
        return LADDER_BLANK;
    }

    private static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
