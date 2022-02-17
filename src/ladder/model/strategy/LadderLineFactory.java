package ladder.model.strategy;

import ladder.model.DrawingStrategy;
import ladder.model.ladder.Height;
import ladder.model.ladder.LadderLine;
import ladder.model.ladder.Point;

import java.util.ArrayList;
import java.util.List;

public class LadderLineFactory {

    private static final int START = 0;
    private static final int BEFORE_LAST = 2;
    private static DrawingStrategy strategy;

    static {
        strategy = LadderLineFactory::getLadderLine;
    }

    public static List<LadderLine> getLadderLines(int playerCount, Height height) {
        final int totalCount = height.getValue();
        List<LadderLine> ladderLines = new ArrayList<>();

        for (int index = START; index < totalCount; index++) {
            LadderLine ladderLine = strategy.horizontalStrategy(playerCount);
            ladderLines.add(ladderLine);
        }
        return ladderLines;
    }

    private static LadderLine getLadderLine(int count) {
        List<Point> points = new ArrayList<>();

        Point point = getFirstPoint(points);
        points.addAll(getMiddlePoints(count, point));
        Point beforeLastPoint = getBeforeLastPoint(points, count);
        addLastPoint(points, beforeLastPoint);
        return new LadderLine(points);
    }

    private static Point getFirstPoint(List<Point> points) {
        Point point = PointFactory.getFirstPoint();
        points.add(point);
        return point;
    }

    private static List<Point> getMiddlePoints(int count, Point point) {
        List<Point> points = new ArrayList<>();
        for (int index = 1; index < count - 1; index++) {
            point = point.next();
            points.add(point);
        }
        return points;
    }

    private static void addLastPoint(List<Point> points, Point point) {
        point = PointFactory.getLastPoint(point);
        points.add(point);
    }

    private static Point getBeforeLastPoint(List<Point> points, int index) {
        int beforeLast = index - BEFORE_LAST;
        return points.get(beforeLast);
    }
}
