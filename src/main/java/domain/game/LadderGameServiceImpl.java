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
    public String getResultMap() {
        String ladderString = buildLadderString(ladderGame.getLadder());
        return ladderString;
    }

    private String buildLadderString(Ladder ladder) {
        return IntStream.range(0, ladder.height())
                .mapToObj(row -> makeLadderRowString(ladder, row))
                .collect(Collectors.joining("\n"));
    }

    private String makeLadderRowString(Ladder ladder, int row) {
        return IntStream.range(0, ladder.width())
                .mapToObj(column -> ladder.getLadderElement(column, row))
                .map(LadderElement::getSymbol)
                .collect(Collectors.joining());
    }
}
