package ladder.model;

public class GameManager {
    private LadderGame ladderGame;

    private GameManager (){};

    private static final GameManager instance = new GameManager();

    public static final GameManager getInstance() {
        if(instance == null){
            return new GameManager();
        }
        return instance;
    }
}
