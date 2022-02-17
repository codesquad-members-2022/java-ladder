package game;

import java.util.ArrayList;
import java.util.List;

public class GameInfo {
    private int playerNum;
    private int height;
    private List<String> playerNames = new ArrayList<>();

    public GameInfo(int playerNum, int height, List<String> playerNames) {
        this.playerNum = playerNum;
        this.height = height;
        this.playerNames = playerNames;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
