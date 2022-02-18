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

    public String playersName2Text() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(String.format("%6s", player.name2Text()));
        }
        return stringBuilder.toString();
    }
}
