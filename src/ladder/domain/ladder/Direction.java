package ladder.domain.ladder;

import ladder.domain.strategy.DirectionFactory;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;
    private static final String UNDRAWABLE = "선을 그릴 수 없습니다.";

    public Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(UNDRAWABLE);
        }
    }

    void validateDirection(){
        if(this.left && this.right){
            throw new IllegalArgumentException(UNDRAWABLE);
        }
    }

    public Direction next() {
        if (hasRight()) {
            return DirectionFactory.getLastDirection(this);
        }
        return DirectionFactory.getNextDirection(this);
    }

    public boolean hasRight() {
        return this.right;
    }

    public boolean hasLeft() {
        return this.left;
    }

    public boolean getRight(){
        return this.right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
