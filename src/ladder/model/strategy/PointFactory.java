package ladder.model.strategy;

import ladder.model.ladder.Point;
import ladder.system.Configuration;

public class PointFactory {

    private static final int ZERO = 0;
    private static final int NEXT = 1;

    public static Point getFirstPoint() {
        boolean right = Configuration.randomGenerator.getBoolean();
        return new Point(ZERO, DirectionFactory.getFirst(right));
    }

    public static Point getNextPoint(Point point) {
        return new Point(point.getIndex() + NEXT, DirectionFactory.getNextDirection(point.getDirection()));
    }

    public static Point getLastPoint(Point point) {
        return new Point(point.getIndex() + NEXT, DirectionFactory.getLast(point));
    }

}
