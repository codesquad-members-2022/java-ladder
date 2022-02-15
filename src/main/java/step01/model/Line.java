package step01.model;

import java.util.List;
import java.util.Objects;

public class Line {
    public static final String LINE_MAKE_ERROR_MESSAGE = "Line의 x좌표는 같고, y좌표는 2차이 나야 합니다.";
    private final List<Position> positions;

    public Line(List<Position> positions) {
        if(!isValidLinePositions(positions)){
            throw new IllegalArgumentException(LINE_MAKE_ERROR_MESSAGE);
        }
        this.positions = positions;
    }

    private boolean isValidLinePositions(List<Position> positions) {
        Position first = positions.get(0);
        Position second = positions.get(1);
        return first.isSameX(second) && first.isDistanceTwo(second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(positions, line.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
