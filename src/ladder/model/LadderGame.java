package ladder.model;

import ladder.model.ladder.Height;
import ladder.model.ladder.Ladder;
import ladder.model.ladder.LadderLines;
import ladder.system.Configuration;

public class LadderGame {

    private Ladder ladder;

    private LadderGame (){
        this.ladder = Configuration.ladder;
    }

    private static final LadderGame instance = new LadderGame();

    public static final LadderGame getInstance() {
        if(instance == null){
            return new LadderGame();
        }
        return instance;
    }

    public LadderLines drawLadder(Names names, Height height) {
        return ladder.getLadderLines(names, height);
    }
}
