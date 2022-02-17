package domain.game;

public interface LadderGameService {

    void initLadderGame(int numberOfUsers, int height);
    String getResultMap();
}
