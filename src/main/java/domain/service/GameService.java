package domain.service;

import domain.Ladder;
import domain.User;

public class GameService {
    private User user;
    private Ladder ladder;

    public GameService(int ladderHeight, String[] user) {
        this.user = new User(user);
        this.ladder = new Ladder(ladderHeight);
    }

    public String getGameResult() {
        StringBuilder sb = new StringBuilder();

        sb.append(user.toString());
        sb.append(ladder.toString());

        return sb.toString();
    }
}
