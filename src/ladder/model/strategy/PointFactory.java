package ladder.model.strategy;

import ladder.model.ladder.Point;

public class PointFactory {

    private static final int ZERO = 0;

    public static Point getFirstPoint(Boolean right) {
        return new Point(ZERO, DirectionFactory.getFirst(right));
    }
}
