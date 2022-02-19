package model;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Line {

    private final int lineLength;
    private final Random random = new Random(System.currentTimeMillis());
    private final List<LadderUnit> ladderUnits = List.of(LadderUnit.SPACE, LadderUnit.STEP, LadderUnit.STEP);
    private final StringBuilder lineResult = new StringBuilder();
    private int index;

    public Line(int userCount) {
        this.lineLength = userCount + (userCount - 1);
        createLine();
    }

    private void createLine() {
        for (int lineNumber = 0; lineNumber < this.lineLength; lineNumber++) {
            String value = extractedLineValue(lineNumber);
            try {
                lineResult.append(value);
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private String extractedLineValue(int lineNumber) {
        if (isEven(lineNumber)) {
            return LadderUnit.RAIL.getLadderUnit();
        }
        return spaceCheck();
    }

    private String spaceCheck() {
        if (index != 0) {
            index = 0;
            return ladderUnits.get(index).getLadderUnit();
        }
        int ladderUnitIndex = random.nextInt(ladderUnits.size());
        index = ladderUnitIndex;
        return ladderUnits.get(ladderUnitIndex).getLadderUnit();
    }

    private boolean isEven(int lineNumber) {
        return lineNumber % 2 == 0;
    }

    @Override
    public String toString() {
        return lineResult.toString();
    }
}
