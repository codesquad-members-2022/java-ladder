package util;

import model.game.player.Player;

import java.util.ArrayList;
import java.util.List;

import static message.GameMessage.*;
import static validator.InputValidator.*;

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
