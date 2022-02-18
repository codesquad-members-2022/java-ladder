package domain.ladder;

public class LadderCreator {
    public static Ladder createLadder(int ladderHeight, int ladderWidth) {
        if (!validateLadderHeight(ladderHeight)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        return new Ladder(ladderHeight, ladderWidth);
    }

    private static boolean validateLadderHeight(int lineCount) {
        return lineCount >= 1;
    }

}
