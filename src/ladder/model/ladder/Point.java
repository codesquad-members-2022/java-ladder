package ladder.model.ladder;

import ladder.model.Direction;
import ladder.model.Points;

public class Point {

    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (this.direction.isRight()) {
            return index + RIGHT;
        }
        if (this.direction.isLeft()) {
            return index + LEFT;
        }
        return this.index;
    }

    public Point next() {
        return Points.of(index + RIGHT, direction.next());
    }

    public Point last() {
        return null;
    }
}
