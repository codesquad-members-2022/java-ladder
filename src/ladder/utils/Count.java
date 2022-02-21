package ladder.utils;

import java.util.Objects;

public class Count {

    private final int value;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 15;
    private static final String INDEX_OUT_OF_RANGE = "최소 1이상, 최대 15 이하의 숫자만 입력하실 수 있습니다.";

    public Count(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalStateException(INDEX_OUT_OF_RANGE);
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
