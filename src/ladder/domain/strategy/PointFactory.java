package ladder.domain.strategy;

import ladder.domain.ladder.Point;

public class PointFactory {

    private static final int START = 0;
    private static final int NEXT = 1;

    public static Point getFirstPoint() {
        return new Point(START, DirectionFactory.getFirstDirection());
    }

    public static Point getNextPoint(Point point) {
        return new Point(point.getIndex() + NEXT, DirectionFactory.getNextDirection(point));
    }

    public static Point getLastPoint(Point point) {
        return new Point(point.getIndex() + NEXT, DirectionFactory.getLastDirection(point));
    }
}
