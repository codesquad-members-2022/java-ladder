package domain;

import Util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public int countOfPlayers() {
        return players.size();
    }

    public String playersName2Text() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(String.format("%6s", player.name2Text()));
        }
        return stringBuilder.toString();
    }

    public boolean containsPlayer(String name) {
        return players.stream().anyMatch(player -> player.isName(name));
    }

    public String findName(int position) {
        Optional<Player> target = players.stream().filter(player -> player.isCorrectPosition(position)).findFirst();
        if (target.isPresent()) {
            return target.get().findNameWithPosition(position);
        }
        throw new IllegalArgumentException();
    }

    public void rideLadder(Ladder ladder) {
        players.forEach(player -> player.ride(ladder));
    }

}
