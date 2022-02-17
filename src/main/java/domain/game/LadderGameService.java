package domain.game;

import domain.ladder.Ladder;

public interface LadderGameService {

    void initLadderGame(int numberOfUsers, int height);
    Ladder getLadder();
}
