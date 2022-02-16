package model.game;

import model.game.ladder.Ladder;
import model.game.player.Player;

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
        int gap = players.stream().map(Player::toString)
                .reduce((s1, s2) -> s1.getBytes().length >= s2.getBytes().length ? s1 : s2)
                .get().length() + 1;
        for (Player player : players) {
            sb.append(String.format("%-" + gap + "s", player));
        }
        return sb + "\n" + ladder;
    }
}
