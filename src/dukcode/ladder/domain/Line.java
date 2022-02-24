package dukcode.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> steps;
    private final int numSteps;

    public Line(int numSteps) {
        this.numSteps = numSteps;
        this.steps = new ArrayList<>(numSteps);

        Random rd = new Random();
        for (int stepIdx = 0; stepIdx < numSteps; ++stepIdx) {
            steps.add(getRandomStep(rd, stepIdx));
        }
    }

    private Boolean getRandomStep(Random rd, int index) {
        if (index == 0) {
            return rd.nextBoolean();
        }

        return steps.get(index - 1) ? false : rd.nextBoolean();
    }

    public Boolean[] getStepArray() {
        return steps.toArray(new Boolean[numSteps]);
    }

    public int getNextPosition(int position) {
        if (isBoundary(position)) {
            return getNextPositionOfBoundary(position);
        }

        return getNextPositionOfNonBoundary(position);
    }

    private boolean isBoundary(int position) {
        if (position == 0 || position == numSteps) {
            return true;
        }
        return false;
    }

    private int getNextPositionOfBoundary(int position) {
        if (position == numSteps) {
            return steps.get(numSteps - 1) ? position - 1  : position;
        }

        // position == 0
        return steps.get(0) ? 1 : 0;
    }

    private int getNextPositionOfNonBoundary(int position) {
        if (steps.get(position - 1) == true) {
            return position - 1;
        }

        if (steps.get(position) == true) {
            return position + 1;
        }

        return position;
    }
}
