package ladder.model;

import java.util.Objects;

public class Count {

    private final int value;
    private final int minValue = 1;
    private final int maxValue = 50;

    public Count(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < minValue || value > maxValue) {
            throw new IllegalStateException();
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return value == count1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
