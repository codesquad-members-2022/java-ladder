package ladder.model;

public class DirectionFactory {

    private static final Boolean NULL = Boolean.FALSE;

    public static Direction getFirst(Boolean right) {
        return new Direction(NULL, right);
    }
}
