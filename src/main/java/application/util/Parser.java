package application.util;

import application.domain.player.Player;

import java.util.ArrayList;
import java.util.List;

import static application.message.GameMessage.*;
import static application.validator.InputValidator.*;

public class Parser {
    public static List<Player> getPlayers(String input) {
        String[] names = input.split(",");
        if (validateNameLength(names)) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_ERROR_MESSAGE);
        }
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }
}
