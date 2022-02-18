package domain.game;

import domain.ladder.Ladder;
import domain.user.User;

import java.util.List;

public class LadderGameServiceImpl implements LadderGameService {

    private static LadderGameServiceImpl instance;

    private final LadderGameMapDecorator ladderGameMapDecorator;

    private LadderGame ladderGame;

    private LadderGameServiceImpl(LadderGameMapDecorator ladderGameMapDecorator) {
        this.ladderGameMapDecorator = ladderGameMapDecorator;
    }

    public static LadderGameServiceImpl getInstance(LadderGameMapDecorator ladderGameMapDecorator) {
        if (instance == null) {
            instance = new LadderGameServiceImpl(ladderGameMapDecorator);
        }
        return instance;
    }

    @Override
    public void initLadderGame(List<User> users, int height) {
        int numberOfUsers = users.size();
        Ladder ladder = new Ladder(numberOfUsers, height);
        this.ladderGame = new LadderGame(users, ladder);
    }

    @Override
    public String getResultMap() {
        List<String> userNames = ladderGame.getUserNames();
        Ladder ladder = ladderGame.getLadder();
        return ladderGameMapDecorator.drawLadderGameMap(userNames, ladder);
    }

}
