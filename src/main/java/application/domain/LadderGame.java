package application.domain;

import application.domain.ladder.Ladder;
import application.domain.player.PlayerList;

public class LadderGame {
    private Ladder ladder;
    private PlayerList players;

    public LadderGame(Ladder ladder, PlayerList players) {
        this.ladder = ladder;
        this.players = players;
    }

    @Override
    public String toString() {
        return players.toString() + ladder.toString();
    }
}
