package application.domain.player;

import java.util.Collections;
import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getTotalNum() {
        return players.size();
    }

    public String output() {
        return players.stream().map(Player::output).reduce("", (s1, s2) -> s1 + s2) + System.lineSeparator();
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }
}
