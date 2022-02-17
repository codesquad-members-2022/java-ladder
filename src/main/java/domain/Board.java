package domain;

import Util.Validation;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final String EMPTY_PART = "    ";

    private final int width;
    private final int height;
    private final List<Floor> frame;
    private final Names names;

    public Board(Names names, int height) {
        this.names = names;
        frame = generateFrame();
        this.width = names.getPlayersCount()*2-1;
        this.height = Validation.checkHeight(height);
    }

    public int getLadderHeight() {
        return height;
    }

    public List<Floor> generateFrame() {
        List<Floor> frame = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            frame.add(new Floor(width));
        }
        return frame;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        frame.forEach(floor -> stringBuilder.append(floor.toString()));
        return stringBuilder.toString();
    }
}

