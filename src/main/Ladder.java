package main;

import java.util.stream.IntStream;

public class Ladder {
    private final int userNum;
    private final int height;
    private final int space;
    private final String[][] ladderArr;

    public Ladder(int userNum, int height) {
        this.userNum = userNum;
        this.height = height;
        space = userNum - 1;
        ladderArr = createLadder();
    }

    private String[][] createLadder() {
        String[][] result = new String[height][userNum + space];
        IntStream.range(0, height).forEach(i -> IntStream.range(0, userNum + space).forEach(j -> {
            if (j % 2 == 0) {
                result[i][j] = "|";
                return;
            }
            result[i][j] = " ";
        }));
        return result;
    }

    public String[][] getLadderArr() {
        return ladderArr;
    }
}
