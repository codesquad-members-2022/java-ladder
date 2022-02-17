package ladder.domain;

import ladder.utils.ValidationUtils;

public class Line {
    private int coordinate;

    public Line(int coordinate) {
        ValidationUtils.validCoordinate(coordinate);
        this.coordinate = coordinate;
    }

    public boolean isLadder(int coordinate) {
        return this.coordinate == coordinate;
    }

    public int getCoordinate() {
        return coordinate;
    }
}
