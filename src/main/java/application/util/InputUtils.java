package application.util;

import application.domain.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {
    public static List<Player> getPlayers(String input) {
        return Arrays.stream(input.split(",")).map(Player::new).collect(Collectors.toList());
    }
}
