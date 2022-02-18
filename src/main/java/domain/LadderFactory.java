package domain;

import domain.ladder.Ladder;
import domain.ladder.RandomLadder;
import domain.ladder.UserDefineLadder;

public class LadderFactory {
    private LadderFactory() {
    }

    public Ladder makeRandomLadder(int height, int numOfPerson){
        return new RandomLadder(height, numOfPerson);
    }

    public Ladder makeUserDefineLadder(int height, int numOfPerson){
        return new UserDefineLadder(height, numOfPerson);
    }
}
