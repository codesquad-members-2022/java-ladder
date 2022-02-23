package application.domain;

import application.domain.ladder.Ladder;
import application.domain.player.Players;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    public LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public void start() {
        ladder.createLadder();
    }

    public String screen() {
        return players.output() + ladder.output();
    }

    @Override
    public String toString() {
        return "LadderGame{" +
                "ladder=" + ladder +
                ", players=" + players +
                '}';
    }
}
