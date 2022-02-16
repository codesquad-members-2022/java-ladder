package ladder.model;

public class Direction {

    private static final int MOVING_LEFT = -1;
    private static final int IN_PLACE = 0;
    private static final int MOVING_RIGHT = 1;

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {

    }
}
