package domain.game;

import domain.user.User;

import java.util.List;

public interface LadderGameService {

    void initLadderGame(List<User> users, int height);
    String getResultMap();
}
