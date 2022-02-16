package ladder.model.ladder;

import java.util.Objects;

public class Height {

    private final int value;
    private static final int ONE = 1;
    private static final int DOUBLE = 2;

    public Height(int value) {
        this.value = calculateWidth(value);
    }

    private int calculateWidth(int value) {
        return value * DOUBLE - ONE;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height that = (Height) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
