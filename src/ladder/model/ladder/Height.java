package ladder.model.ladder;

import java.util.Objects;

public class Height {

    private final int value;
    private static final int MIN_HEIGHT = 2;
    private static final int MAX_HEIGHT = 15;
    private static final String INPUT_VALID_HEIGHT = "최소 2 이상, 최대 15 이하의 높이를 입력해주세요.";

    public Height(int height) {
        validateHeight(height);
        this.value = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT){
            throw new IllegalStateException(INPUT_VALID_HEIGHT);
        }
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
