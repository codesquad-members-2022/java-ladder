package ladder;

import java.util.Random;
import java.util.Scanner;

public class Ladder {
    public String[][] makeLadder(int[] param) {
        return getDrawingLadder(getLadderArr(getLine(param[0]), param[1]));
    }

    private int getLine(int n) {
        return (2 * n) - 1;
    }

    private String[][] getLadderArr(int line, int m) {
        String[][] ladder = new String[line][m];
        return ladder;
    }

    private String[][] getDrawingLadder(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) { //세로
            for (int j = 0; j < ladder[i].length; j++) {//가로
                ladder = drawingStick(ladder, i, j);
                ladder = drawingLine(ladder, i, j);
            }
        }
        return ladder;
    }

    private String[][] drawingLine(String[][] ladder, int i, int j) {
        if (getRandomNum() == 0) {
            ladder[i][j] = "--";
            return ladder;
        }
        ladder[i][j] = "  ";
        return ladder;
    }

    private String[][] drawingStick(String[][] ladder, int i, int j) {
        if (j % 2 == 0){
            ladder[i][j] = "|";
        }
        return ladder;
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(2);
    }

}
