package model.game;

import model.game.ladder.Ladder;
import model.game.player.Player;
import util.GameUtil;

import java.util.List;

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
        int gap = GameUtil.getMaxPlayerName(players) + 1;
        for (Player player : players) {
            sb.append(String.format("%-" + gap + "s", player));
        }
        return sb + "\n" + ladder;
    }
}
