package domain;

import java.util.Objects;

public class Position {
    public final String POSITION_INPUT_ERROR_MESSAGE = "범위는 0이상부터 가능합니다.";
    private final int x;
    private final int y;

    public Position(int x, int y) {
        if(!isValidPosition(x, y)){
            throw new IllegalArgumentException(POSITION_INPUT_ERROR_MESSAGE);
        }
        this.x = x;
        this.y = y;
    }

    private boolean isValidPosition(int x, int y){
        return isValidArgument(x) && isValidArgument(y);
    }
    private boolean isValidArgument(int num){
        return num >= 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
