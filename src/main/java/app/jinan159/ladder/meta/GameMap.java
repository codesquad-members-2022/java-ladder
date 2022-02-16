package app.jinan159.ladder.meta;

import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private final List<List<LadderElement>> gameMap;
    private final int width;
    private final int height;

    public GameMap(int participantCount, int height) {
        this.width = participantCount * 2 - 1;
        this.height = height;
        gameMap = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            gameMap.add(new ArrayList<>(width));
        }
    }

    public LadderElement get(int x, int y) {
        return gameMap.get(y).get(x);
    }

    public void set(int x, int y, LadderElement value) {
        gameMap.get(y).add(x, value);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String gameMapToString() {
        StringBuilder sb = new StringBuilder();

        for (List<LadderElement> row : this.gameMap) {
            sb.append(rowToString(row));
            sb.append('\n');
        }

        return sb.toString();
    }

    private String rowToString(List<LadderElement> row) {
        StringBuilder sb = new StringBuilder();
        for (LadderElement col : row) {
            sb.append(col.getMark());
        }

        return sb.toString();
    }

}
