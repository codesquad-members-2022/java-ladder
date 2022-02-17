package domain.game;

import domain.ladder.Ladder;
import domain.ladder.LadderElement;
import domain.ladder.LadderFactory;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public void initLadderGame(int numberOfUsers, int height) {
        Ladder ladder = ladderFactory.create(numberOfUsers, height);
        this.ladderGame = new LadderGame(ladder);
    }

    @Override
    public Ladder getLadder() {
        return ladderGame.getLadder();
    }
}
