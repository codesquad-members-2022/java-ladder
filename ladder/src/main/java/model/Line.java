package model;

import java.util.List;
import java.util.Random;

public class Line {

    private final Random random = new Random(System.currentTimeMillis());
    private final List<String> ladderUnits = List.of(LadderUnit.SPACE.getLadderUnit(), LadderUnit.STEP.getLadderUnit(), LadderUnit.STEP.getLadderUnit());
    StringBuilder sb = new StringBuilder();

    public Line(int userCount) {
        int lineLength = userCount + (userCount - 1);
        createLine(lineLength);
    }

    private void createLine(int lineLength) {
        for (int lineNumber = 0; lineNumber < lineLength; lineNumber++) {
            if (isEven(lineNumber)) {
                sb.append(LadderUnit.RAIL.getLadderUnit());
                continue;
            }
            sb.append(LadderUnit.STEP.getLadderUnit());
        }
    }

    private boolean isEven(int lineNumber) {
        return lineNumber % 2 == 0;
    }

    public String printLine() {
        return sb.toString();
    }
}
