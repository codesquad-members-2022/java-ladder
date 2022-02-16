package domain.game;

import domain.ladder.Ladder;

public interface LadderGameService {

    void initLadderGame(int entry, int height);
    Ladder getLadder();
}
