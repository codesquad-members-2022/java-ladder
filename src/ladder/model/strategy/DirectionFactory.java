package ladder.model.strategy;

import ladder.model.Direction;
import ladder.model.ladder.Point;
import ladder.system.Configuration;

public class DirectionFactory {

    private static final Boolean NULL = Boolean.FALSE;

    public static Direction getFirst(Boolean right) {
        return new Direction(NULL, right);
    }

    public static Direction getNextDirection(Direction direction) {
        boolean next = Configuration.randomGenerator.getBoolean();
        return new Direction(direction.getRight(), next);
    }

    public static Direction getLast(Point point) {
        boolean previous = point.getDirection().getRight();
        return new Direction(previous, NULL);
    }

    public static Direction getLast(Direction direction) {
        return new Direction(direction.getRight(), NULL);
    }
}
