package model;

import java.util.List;
import java.util.Random;

public class Line {

    private final int lineLength;
    private final Random random = new Random(System.currentTimeMillis());
    private final List<String> ladderUnits = List.of(LadderUnit.SPACE.getLadderUnit(), LadderUnit.STEP.getLadderUnit(), LadderUnit.STEP.getLadderUnit());

    public Line(int userCount) {
        this.lineLength = userCount + (userCount - 1);
    }

    public String createLine() {
        StringBuilder sb = new StringBuilder();
        for (int lineNumber = 0; lineNumber < this.lineLength; lineNumber++) {
            if (isEven(lineNumber)) {
                sb.append(LadderUnit.RAIL.getLadderUnit());
                continue;
            }
            sb.append(LadderUnit.STEP.getLadderUnit());
        }
        return sb.toString();
    }

    private boolean isEven(int lineNumber) {
        return lineNumber % 2 == 0;
    }
}
