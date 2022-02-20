package app.jinan159.ladder.config;

public class GameConfig {

    private final int nameLength;
    private final int ladderSize;


    private GameConfig(int nameLength) {
        this.nameLength = nameLength;
        this.ladderSize = nameLength;
    }

    public static GameConfig createWithNameLength(int nameLength) {
        return new GameConfig(nameLength);
    }

    public int getNameLength() {
        return nameLength;
    }

    public int getLadderSize() {
        return ladderSize;
    }
}
