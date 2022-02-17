package application.util;

import application.domain.player.Player;

import java.util.ArrayList;
import java.util.List;

import static application.message.GameMessage.LENGTH_EXCEEDED_ERR_MESSAGE;
import static application.validator.InputValidator.*;

public class Parser {
    public static List<Player> getPlayers(String input) {
        String[] names = input.split(",");
        if (validateNameLength(names)) {
            throw new IllegalArgumentException(LENGTH_EXCEEDED_ERR_MESSAGE);
        }
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }
}
