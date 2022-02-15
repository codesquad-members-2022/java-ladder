package domain.game;

import domain.ladder.Ladder;

public class LadderGame {

    private final Ladder ladder;

    LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    Ladder getLadder() {
        return this.ladder;
    }
}
