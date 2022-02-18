package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int ladderWidth;
    private final int ladderHeight;
    private List<Line> ladders;


    public Ladder(int ladderHeight, int ladderWidth) {
        if (!validateLadderHeight(ladderHeight)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        this.ladderHeight = ladderHeight;
        this.ladderWidth = ladderWidth;
        initLadder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ladders.forEach(line->{
            StringBuilder row = new StringBuilder();
            row.append(line.toString());
            sb.append(" " + row + "\n");
        });
        return sb.toString();
    }

    private void initLadder() {
        ladders = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladders.add(Line.createRandomStep(ladderWidth));
        }
    }

    private boolean validateLadderHeight(int lineCount) {
        return lineCount >= 1;
    }
}
