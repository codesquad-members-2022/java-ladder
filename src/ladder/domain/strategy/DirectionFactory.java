package ladder.domain.strategy;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Point;
import ladder.system.Configuration;

import static java.lang.Boolean.FALSE;

public class DirectionFactory {

    private static final Boolean NONE = FALSE;

    public static Direction getFirstDirection() {
        final boolean right = Configuration.randomGenerator.getBoolean();
        return new Direction(NONE, right);
    }

    public static Direction getNextDirection(Point point) {
        Direction direction = point.getDirection();
        if (direction.hasRight()) {
            return new Direction(direction.getRight(), NONE);
        }
        boolean next = Configuration.randomGenerator.getBoolean();
        return new Direction(direction.getRight(), next);
    }

    public static Direction getLastDirection(Point point) {
        boolean previous = point.getDirection().getRight();
        return new Direction(previous, NONE);
    }

    public static Direction getLastDirection(Direction direction) {
        boolean previous = direction.getRight();
        return new Direction(previous, NONE);
    }

    public static Direction getNextDirection(Direction direction) {
        boolean previous = direction.getRight();
        boolean next = Configuration.randomGenerator.getBoolean();
        return new Direction(previous, next);
    }
}
