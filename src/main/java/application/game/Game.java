package application.game;

import application.domain.ladder.Ladder;
import application.domain.player.Player;
import application.util.GameUtils;

import java.util.List;

import static application.util.StringUtils.rpad;

public class Game {
    private final Ladder ladder;
    private final List<Player> players;

    public Game(Ladder ladder, List<Player> players) {
        this.ladder = ladder;
        this.players = players;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int pad = GameUtils.getMaxPlayerName(players) + 1;
        for (Player player : players) {
            sb.append(rpad(pad, player.toString()));
        }
        return sb + "\n" + ladder;
    }
}
