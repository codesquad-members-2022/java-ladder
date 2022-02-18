package domain;

import Util.Validation;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(String names) {
        this.players = splitNames(names);
        Validation.checkPlayers(this.players.size());
    }

    private List<Player> splitNames(String names) {
        List<Player> players = new ArrayList<>();
        String[] nameList = names.split(",");
        for (int i = 0; i < nameList.length ; i++) {
            players.add(new Player(nameList[i],i));
        }
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(String.format("%6s", player));
        }
        return stringBuilder.toString();
    }
}
