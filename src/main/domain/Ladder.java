package main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import main.util.ListDeepCopy;

public class Ladder {

    private List<List<String>> stringBoard;
    private final int width;
    private final int height;
    private boolean prev;
    private Random random;

    public Ladder(int width, int height) {
        this.width = width - 1;
        this.height = height;
        this.random = new Random();
        init();
    }

    public void init() {
        stringBoard = new ArrayList<>();
        makeRandomLadder();
    }

    public void makeRandomLadderCol() {
        List<String> temp = new ArrayList<>();
        for (int j = 0; j < width; j++) {
            temp.add(ladderSign(random.nextBoolean()));
        }
        stringBoard.add(temp);
        prev = false;
    }

    public void makeRandomLadderRow() {
        for (int i = 0; i < height; i++) {
            makeRandomLadderCol();
        }
    }

    public void makeRandomLadder() {
        makeRandomLadderRow();
    }

    public List<List<String>> getBoard() {
        return ListDeepCopy.string2dDeepCopy(stringBoard);
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
