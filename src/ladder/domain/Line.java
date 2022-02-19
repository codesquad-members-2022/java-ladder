package ladder.domain;

import java.util.ArrayList;

public class Line {
    private static final boolean STEP = true;
    private static final boolean BLANK = false;
    private static final double PROBABILITY = 0.5;

    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(int countOfPlayer) {
        for (int i = 0; i < countOfPlayer - 1; i++) {
            points.add(createRandomly());
        }
    }

    private boolean createRandomly() {
        return (Math.random() > PROBABILITY && !hasPreviousStep()) ? STEP : BLANK;
    }

    private boolean hasPreviousStep() {
        return !points.isEmpty() && points.get(points.size() - 1);
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}
