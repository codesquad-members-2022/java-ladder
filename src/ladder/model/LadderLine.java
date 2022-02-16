package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        validateLadderLine(points);
        this.points = copy(points);
    }

    private void validateLadderLine(List<Point> points) {
        Objects.requireNonNull(points);
    }

    private List<Point> copy(List<Point> points) {
        return new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        if (this.points.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(copy(this.points));
    }
}
