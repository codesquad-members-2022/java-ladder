package main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import main.util.ListDeepCopy;

public class HorizontalLine implements Cloneable{

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
            boolean result = random.nextBoolean() && prevNoPoint;
            points.add(result);
            prevNoPoint = updatePrevNoPoint(result);
        }
    }

    public boolean updatePrevNoPoint(boolean result) {
        return !result;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public void setPoints(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public HorizontalLine clone() {
        try {
            HorizontalLine clone = (HorizontalLine) super.clone();
            clone.setPoints(ListDeepCopy.listDeepCopy(this.getPoints()));
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
