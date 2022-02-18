package domain.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private List<Player> players = new ArrayList<>();

    private PlayerList() {
    }

    public static PlayerList of(String... names) throws IllegalArgumentException {
        PlayerList players = new PlayerList();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }

    public void add(Player player) {
        players.add(player);
    }

    public int count() {
        return players.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(player.getNameWithPadding());
            sb.append("\t");
        }
        return sb.toString();
    }
}
