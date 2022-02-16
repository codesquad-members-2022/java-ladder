package main;

import java.util.stream.IntStream;

public class LadderGame {
    private static final char BLANK = ' ';
    private static final char RUNG = '-';
    private static final char RAIL = '|';
    private final int userNum;
    private final int height;
    private final int space;
    private final Character[][] ladderArr;

    public LadderGame(int userNum, int height) {
        this.userNum = userNum;
        this.height = height;
        space = userNum - 1;
        ladderArr = createLadder();
    }

    private Character[][] createLadder() {
        Character[][] result = new Character[height][userNum + space];
        IntStream.range(0, height).forEach(i -> IntStream.range(0, userNum + space)
                .forEach(j -> generate(result, i, j)));
        return result;
    }

    private void generate(Character[][] result, int i, int j) {
        if (j % 2 == 0) {
            result[i][j] = RAIL;
            return;
        }
        result[i][j] = (Math.random() > 0.5) ? BLANK : RUNG;
    }

    public Character[][] getLadderArr() {
        return ladderArr;
    }
}
