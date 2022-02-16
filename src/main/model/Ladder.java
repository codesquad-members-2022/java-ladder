package main.model;

import java.util.Random;
import main.Util;

public class Ladder {

    private Boolean[][] boolBoard;
    private String[][] stringBoard;
    private final int width;
    private final int height;

    public Ladder(int width, int height) {
        this.width = width - 1;
        this.height = height;
        init();
    }

    public void init() {
        stringBoard = new String[height][width];
        boolBoard = new Boolean[height][width];
        makeRandomLadder();
    }

    public void makeRandomLadderCol(Random random, int i) {
        for (int j = 0; j < width; j++) {
            boolBoard[i][j] = random.nextBoolean();
            stringBoard[i][j] = ladderSign(boolBoard[i][j]);
        }
    }

    public void makeRandomLadderRow(Random random) {
        for (int i = 0; i < height; i++) {
            makeRandomLadderCol(random, i);
        }
    }

    public void makeRandomLadder() {
        Random random = new Random();
        makeRandomLadderRow(random);
    }

    public String[][] getBoard() {
        return Util.string2dDeepCopy(stringBoard,height,width);
    }

    public String ladderSign(boolean b) {
        if (b) {
            return "-";
        }
        return " ";
    }
}
