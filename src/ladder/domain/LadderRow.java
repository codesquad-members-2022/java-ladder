package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {
    private final List<Boolean> steps;
    private final Random random = new Random();

    protected LadderRow(int width) {
        steps = new ArrayList<>(width);
        build(width);
    }

    protected boolean hasStepAt(int xPosition) {
        return steps.get(xPosition);
    }

    protected boolean isEmpty(int xPosition) {
        return !(hasStepAt(xPosition));
    }

    private void build(int width) {
        for (int i = 0; i < width; i++) {
            steps.add(drawStep(i));
        }
    }

    private boolean drawStep(int xPosition) {
        if (xPosition == 0 || isEmpty(xPosition - 1)) {
            return randomize();
        }

        return false;
    }

    private boolean randomize() {
        return random.nextBoolean();
    }
}
