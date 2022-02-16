package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = getPoints(points);
    }

    private List<Point> getPoints(List<Point> points) {
        return new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        if (this.points.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(getPoints(this.points));
    }
}
