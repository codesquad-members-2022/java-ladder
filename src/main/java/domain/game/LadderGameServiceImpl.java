package domain.game;

import domain.ladder.Ladder;
import domain.ladder.LadderFactory;

public class LadderGameServiceImpl implements LadderGameService {

    private static LadderGameServiceImpl instance;

    private final LadderFactory ladderFactory;
    private LadderGame ladderGame;

    private LadderGameServiceImpl(LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public static LadderGameServiceImpl getInstance(LadderFactory ladderFactory) {
        if (instance == null) {
            instance = new LadderGameServiceImpl(ladderFactory);
        }
        return instance;
    }

    @Override
    public void initLadderGame(int entry, int height) {
        Ladder ladder = ladderFactory.create(entry, height);
        this.ladderGame = new LadderGame(ladder);
    }

    @Override
    public Ladder getLadder() {
        return ladderGame.getLadder();
    }

}
