package main.domain;

import java.util.ArrayList;
import java.util.List;
import main.util.ListDeepCopy;

public class Ladder {

    private List<HorizontalLine> board;
    private final int width;
    private final int height;

    public Ladder(int width, int height) {
        this.width = width - 1;
        this.height = height;
        init();
    }

    public void init() {
        board = new ArrayList<>();
        makeBoard();
    }

    public void makeBoard() {
        for (int i = 0; i < height; i++) {
            board.add(new HorizontalLine(width));
        }
    }

    public List<HorizontalLine> getBoard() {
        return ListDeepCopy.boardDeepCopy(board);
    }

//    public String ladderSign(boolean b) {
//        if (b && !prev) {
//            prev = true;
//            return "-----";
//        }
//        prev = false;
//        return "     ";
//    }
}
