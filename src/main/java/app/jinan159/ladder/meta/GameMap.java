package app.jinan159.ladder.meta;

public class GameMap {

    private final Elements[][] gameMap;

    public GameMap(int participantCount, int height) {
        this.gameMap = new Elements[height][participantCount * 2 - 1];
    }

    public Elements get(int x, int y) {
        return gameMap[y][x];
    }

    public void set(int x, int y, Elements value) {
        gameMap[y][x] = value;
    }

    public int getWidth() {
        return gameMap[0].length;
    }

    public int getHeight() {
        return gameMap.length;
    }
}
