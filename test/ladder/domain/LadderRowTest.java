package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderRowTest {
    @Test
    @DisplayName("생성시 가로줄(step)이 연속되지 않는 것을 확인")
    void isBuiltCorrectly() {
        assertAll(() -> assertTrue(checkForAdjoinedStepsInLadderRow(5)),
                () -> assertTrue(checkForAdjoinedStepsInLadderRow(7)),
                () -> assertTrue(checkForAdjoinedStepsInLadderRow(10)));
    }

    boolean checkForAdjoinedStepsInLadderRow(int width) {
        LadderRow row = new LadderRow(width);

        return checkNextStep(row, width, 0);
    }

    boolean checkNextStep(LadderRow row, int width, int xPosition) {
        if (xPosition == width - 1) {
            return true;
        }
        if (row.hasStepAt(xPosition) && row.hasStepAt(xPosition + 1)) {
            return false;
        }
        return checkNextStep(row, width, xPosition + 1);
    }
}
