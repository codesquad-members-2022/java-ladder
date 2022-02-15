package ladder.model;

public class LadderGame {

    private LadderGame (){};

    private static final LadderGame instance = new LadderGame();

    public static final LadderGame getInstance() {
        if(instance == null){
            return new LadderGame();
        }
        return instance;
    }
}
