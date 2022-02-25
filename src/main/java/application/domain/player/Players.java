package application.domain.player;

import application.domain.result.Result;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getTotalNum() {
        return players.size();
    }

    public String output() {
        return players.stream().map(Player::output).reduce("", (s1, s2) -> s1 + s2) + System.lineSeparator();
    }

    public String resultOutput(Map<String, Result> resultMap) {
        return players.stream()
                .map(player -> String.format("%s: %s\n", player.getName(), resultMap.get(player.getName()).output()))
                .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }
}
