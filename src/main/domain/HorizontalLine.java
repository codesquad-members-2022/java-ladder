package main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HorizontalLine {

    private List<Boolean> points = new ArrayList<>();
    private Random random;
    private boolean prevNoPoint;
    private final int length;

    public HorizontalLine(int length) {
        this.length = length;
        init();
    }

    public void init() {
        this.random = new Random();
        this.points = new ArrayList<>();
        this.prevNoPoint = true;
        fillRandomPoint();
    }

    public void fillRandomPoint() {
        for (int j = 0; j < length; j++) {
            boolean temp = random.nextBoolean() && prevNoPoint;
            points.add(temp);
            prevNoPoint = updatePrevNoPoint(temp);
        }
    }

    public boolean updatePrevNoPoint(boolean result) {
        if (result) {
            return false;
        }
        return true;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
