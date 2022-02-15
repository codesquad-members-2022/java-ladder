package domain.game;

import domain.ladder.Ladder;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

}
