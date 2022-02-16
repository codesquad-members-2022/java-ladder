package ladder.model;

import java.util.Objects;

public class Count {

    private final int value;

    public Count(int value) {
        this.value = value;
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
