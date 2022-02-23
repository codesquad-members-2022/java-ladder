package application.util;

import application.domain.player.Player;
import application.domain.result.Result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {
    public static final String END_CMD = "춘식이";
    public static final String DELIMITER = ",";

    public static List<Player> getPlayers(String input) {
        return Arrays.stream(input.split(DELIMITER)).map(Player::new).collect(Collectors.toList());
    }

    public static List<Result> getResult(String input) {
        return Arrays.stream(input.split(DELIMITER)).map(Result::new).collect(Collectors.toList());
    }
}
