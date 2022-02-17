package domain.game;

import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.user.User;

import java.util.List;

public class LadderGameServiceImpl implements LadderGameService {

    private static LadderGameServiceImpl instance;

    private final LadderFactory ladderFactory;
    private final LadderGameMapDecorator ladderGameMapDecorator;

    private LadderGame ladderGame;

    private LadderGameServiceImpl(LadderFactory ladderFactory, LadderGameMapDecorator ladderGameMapDecorator) {
        this.ladderFactory = ladderFactory;
        this.ladderGameMapDecorator = ladderGameMapDecorator;
    }

    public static LadderGameServiceImpl getInstance(LadderFactory ladderFactory, LadderGameMapDecorator ladderGameMapDecorator) {
        if (instance == null) {
            instance = new LadderGameServiceImpl(ladderFactory, ladderGameMapDecorator);
        }
        return instance;
    }

    @Override
    public void initLadderGame(List<User> users, int height) {
        int numberOfUsers = users.size();
        Ladder ladder = ladderFactory.create(numberOfUsers, height);
        this.ladderGame = new LadderGame(users, ladder);
    }

    @Override
    public String getResultMap() {
        List<String> userNames = ladderGame.getUserNames();
        Ladder ladder = ladderGame.getLadder();
        return ladderGameMapDecorator.drawLadderGameMap(userNames, ladder);
    }

}
