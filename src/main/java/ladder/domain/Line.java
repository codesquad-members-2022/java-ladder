package ladder.domain;

public class Line {
    private int coordinate;

    public Line(int coordinate) {
        if (coordinate < 0) {
            throw new IllegalArgumentException("좌표의 값은 0 이상 이어야 합니다.");
        }
        this.coordinate = coordinate;
    }

    public boolean isLadder(int coordinate) {
        return this.coordinate == coordinate;
    }
}
