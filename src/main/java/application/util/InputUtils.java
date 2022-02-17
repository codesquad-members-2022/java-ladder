package application.util;

import application.domain.player.Player;

import java.util.ArrayList;
import java.util.List;

public class InputUtils {
    public static List<Player> getPlayers(String input) {
        String[] names = input.split(",");
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }
}
