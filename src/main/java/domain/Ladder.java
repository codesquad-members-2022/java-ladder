package domain;

import Util.Validation;
import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int width;
    private final int height;
    private final List<Floor> board;

    public Ladder(int count, int height) {
        this.width = count;
        this.height = Validation.checkHeight(height);
        board = generateBoard();
    }

    public int getLadderHeight() {
        return height;
    }

    public List<Floor> generateBoard() {
        List<Floor> frame = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            frame.add(new Floor(width));
        }
        return frame;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        board.forEach(floor -> stringBuilder.append(floor.toString()).append('\n'));
        return stringBuilder.toString();
    }
}

