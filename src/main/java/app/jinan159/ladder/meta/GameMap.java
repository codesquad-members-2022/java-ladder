package app.jinan159.ladder.meta;

public class GameMap {

    private final LadderElement[][] gameMap;

    public GameMap(int participantCount, int height) {
        this.gameMap = new LadderElement[height][participantCount * 2 - 1];
    }

    public LadderElement get(int x, int y) {
        return gameMap[y][x];
    }

    public void set(int x, int y, LadderElement value) {
        gameMap[y][x] = value;
    }

    public int getWidth() {
        return gameMap[0].length;
    }

    public int getHeight() {
        return gameMap.length;
    }

    public String gameMapToString() {
        StringBuilder sb = new StringBuilder();

        for (LadderElement[] row : this.gameMap) {
            sb.append(rowToString(row));
            sb.append('\n');
        }

        return sb.toString();
    }

    private String rowToString(LadderElement[] row) {
        StringBuilder sb = new StringBuilder();
        for (LadderElement col : row) {
            sb.append(col.getMark());
        }

        return sb.toString();
    }

}
