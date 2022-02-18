package domain.ladder;

public class LadderCreator {
    public static Ladder createLadder(int ladderHeight, int ladderWidth) {
        return new Ladder(ladderHeight, ladderWidth);
    }

}
