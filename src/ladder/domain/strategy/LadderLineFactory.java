package ladder.domain.strategy;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.LadderLine;
import ladder.domain.ladder.Point;
import ladder.utils.Count;

import java.util.ArrayList;
import java.util.List;

public class LadderLineFactory {

    public static List<LadderLine> getLadderLines(Count playerCount, Height height) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int index = 0; index < height.getValue(); index++) {
            LadderLine ladderLine = getLadderLine(playerCount);
            ladderLines.add(ladderLine);
        }
        return ladderLines;
    }

    private static LadderLine getLadderLine(Count count) {
        return getLineElements(count);
    }

    private static LadderLine getLineElements(Count count) {
        List<Point> points = getPoints(count);
        return new LadderLine(points);
    }

    private static List<Point> getPoints(Count count) {
        List<Point> points = new ArrayList<>();
        Point point = PointFactory.getFirstPoint();
        points.add(point);
        for (int index = 1; index < count.getValue(); index++) {
            point = addPoint(index, count, point, points);
        }
        return points;
    }

    private static Point addPoint(int index, Count count, Point point, List<Point> points) {
        int last = count.getValue() - 1;
        if (index == last) {
            point = PointFactory.getLastPoint(point);
            points.add(point);
            return point;
        }
        point = point.next();
        points.add(point);
        return point;
    }
}
