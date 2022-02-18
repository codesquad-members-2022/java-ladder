package dukcode.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> line;
    private final int numSteps;

    public Line(int numSteps) {
        this.numSteps = numSteps;
        this.line = new ArrayList<>(numSteps);

        Random rd = new Random();
        for (int stepIdx = 0; stepIdx < line.size(); ++stepIdx) {
            line.add(getRandomStep(rd, line, stepIdx));
        }
    }

    private Boolean getRandomStep(Random rd, List<Boolean> line, int index) {
        if (index == 0) {
            return rd.nextBoolean();
        }

        return line.get(index - 1) ? false : rd.nextBoolean();
    }

    public Boolean[] getStepArray() {
        return line.toArray(new Boolean[numSteps]);
    }
}
