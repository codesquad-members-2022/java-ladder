package ladder.model;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {

    }

    public Direction next() {
        return null;
    }

    public boolean isLeft() {
        return false;
    }

    public boolean isRight() {
        return false;
    }
}