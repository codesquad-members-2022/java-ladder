package domain;

import Util.Validation;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final String EMPTY_PART = "    ";

    private final int players;
    private final int height;
    private final List<Floor> frame;

    public Board(int players, int height) {
        this.players = Validation.checkPlayers(players);
        this.height = Validation.checkHeight(height);
        frame = generateFrame();
    }

    public int countPlayers() {
        return players;
    }

    public int getLadderHeight() {
        return height;
    }

    public List<Floor> generateFrame() {
        List<Floor> frame = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            frame.add(new Floor(players*2-1));
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

