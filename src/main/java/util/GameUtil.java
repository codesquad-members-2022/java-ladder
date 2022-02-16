package util;

import model.game.player.Player;

import java.util.List;
import java.util.function.BinaryOperator;

public class GameUtil {
    private static final BinaryOperator<String> compareString = (s1, s2) -> s1.getBytes().length >= s2.getBytes().length ? s1 : s2;

    public static int getMaxPlayerName(List<Player> players) {
        return players.stream().map(Player::toString).reduce(compareString).get().length();
    }
}
