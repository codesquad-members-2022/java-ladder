package application.domain.player;

import java.util.List;

public class PlayerList {
    private List<Player> players;
    private int totalNum;

    public PlayerList(List<Player> players) {
        this.players = players;
        this.totalNum = players.size();
    }

    public int getTotalNum() {
        return totalNum;
    }

    @Override
    public String toString() {
        return players.stream().map(Player::toString).reduce("", (s1, s2) -> s1 + s2) + '\n';
    }
}
