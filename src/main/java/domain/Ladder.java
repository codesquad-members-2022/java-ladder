package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int width;
    private final int height;
    private final List<Floor> board;

    public Ladder(int count, int height) {
        this.width = count - 1;
        this.height = height;
        board = generateBoard();
    }

    public int getWidth() {
        return width;
    }

    public int getLadderHeight() {
        return height;
    }

    public List<Floor> generateBoard() {
        List<Floor> frame = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            frame.add(Floor.getInstance(width));
        }
        return frame;
    }


    public boolean isStep(int row, int col) {
        return board.get(row).isSTEP(col);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "width=" + width +
                ", height=" + height +
                ", board=" + board +
                '}';

    }
}

