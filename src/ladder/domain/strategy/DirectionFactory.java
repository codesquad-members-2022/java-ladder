package ladder.domain.strategy;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Point;
import ladder.system.Configuration;

public class DirectionFactory {

    private static final Boolean NULL = Boolean.FALSE;

    public static Direction getFirstDirection() {
        boolean right = Configuration.randomGenerator.getBoolean();
        return new Direction(NULL, right);
    }

    public static Direction getNextDirection(Point point) {
        Direction direction = point.getDirection();
        if(direction.hasRight()){
            return new Direction(direction.getRight(), NULL);
        }
        boolean next = Configuration.randomGenerator.getBoolean();
        return new Direction(direction.getRight(), next);
    }

    public static Direction getNextDirection(Direction direction) {
        if(direction.hasRight()){
            return new Direction(direction.getRight(), NULL);
        }
        boolean next = Configuration.randomGenerator.getBoolean();
        return new Direction(direction.getRight(), next);
    }

    public static Direction getLastDirection(Point point) {
        boolean previous = point.getDirection().getRight();
        return new Direction(previous, NULL);
    }

    public static Direction getLastDirection(Direction direction) {
        boolean previous = direction.getRight();
        return new Direction(previous, NULL);
    }
}
