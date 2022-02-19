package ladder.domain;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.Names;
import ladder.system.Configuration;

public class LadderGame {

    private Ladder ladder;

    private LadderGame (){
        this.ladder = Configuration.ladder;
    }

    private static final LadderGame instance = new LadderGame();

    public static LadderGame getInstance() {
        if(instance == null){
            return new LadderGame();
        }
        return instance;
    }

    Ladder getLadder(Names names, Height height) {
        return this.ladder.getLadder(names, height);
    }
}
