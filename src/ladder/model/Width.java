package ladder.model;

import java.util.Objects;

public class Width {

    private final int value;
    private static final int ONE = 1;
    private static final int DOUBLE = 2;

    public Width(int value) {
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
        Width that = (Width) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
