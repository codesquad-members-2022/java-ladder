package domain;

import Util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(String[] playerNames) {
        this.players = generatePlayers(playerNames);
    }

    private List<Player> generatePlayers(String[] playerNames) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            players.add(new Player(playerNames[i], i));
        }
        return players;
    }

    public int countOfPlayers() {
        return players.size();
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

    public List<String> getNames() {
        return players.stream().map(Player::name2Text).collect(Collectors.toList());
    }

}
