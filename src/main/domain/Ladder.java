package main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import main.util.Util;

public class Ladder {

    private List<List<String>> stringBoard;
    private final int width;
    private final int height;
    private boolean prev;

    public Ladder(int width, int height) {
        this.width = width - 1;
        this.height = height;
        init();
    }

    public void init() {
        stringBoard = new ArrayList<>();
        makeRandomLadder();
    }

    public void makeRandomLadderCol(Random random, int i) {
        List<String> temp = new ArrayList<>();
        for (int j = 0; j < width; j++) {
            temp.add(ladderSign(random.nextBoolean()));
        }
        stringBoard.add(temp);
        prev = false;
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

    public List<List<String>> getBoard() {
        return Util.stringList2dDeepCopy(stringBoard);
    }

    public String ladderSign(boolean b) {
        if (b && !prev) {
            prev = true;
            return "-----";
        }
        prev = false;
        return "     ";
    }
}
