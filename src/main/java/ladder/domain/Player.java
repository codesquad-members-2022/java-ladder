package ladder.domain;

import java.util.List;

public class Player {

    private static List<String> playerList;

    public static List<String> getPlayerList() {
        return playerList;
    }

    public Player(List<String> playerList) {
        this.playerList = playerList;
    }

    public int getPlayerCount() {
        return playerList.size();
    }

}
