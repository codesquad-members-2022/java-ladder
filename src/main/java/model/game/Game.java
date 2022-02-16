package model.game;

import model.game.ladder.Ladder;
import model.game.player.Player;
import util.GameUtil;

import java.util.List;

public class Game {
    private Ladder ladder;
    private List<Player> players;

    public Game(Ladder ladder, List<Player> players) {
        this.ladder = ladder;
        this.players = players;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        int gap = GameUtil.getMaxPlayerName(players) + 1;
        for (Player player : players) {
            sb.append(String.format("%-" + gap + "s", player));
        }
        return sb + "\n" + ladder;
    }
}
