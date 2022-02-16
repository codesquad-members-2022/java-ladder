package ladder.model;

public class DirectionFactory {

    private static final Boolean NULL = Boolean.FALSE;

    public static Direction getFirst(Boolean right) {
        return new Direction(NULL, right);
    }

    public static Direction getLast(Boolean right) {
        return new Direction(right, NULL);
    }
}
