package dukcode.model.domain;

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
}
