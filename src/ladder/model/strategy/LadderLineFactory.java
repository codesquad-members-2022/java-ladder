package ladder.model.strategy;

import ladder.model.Count;
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

    public static List<LadderLine> getLadderLines(Count playerCount, Height height) {
        final int totalCount = height.getValue();
        List<LadderLine> ladderLines = new ArrayList<>();

        for (int index = START; index < totalCount; index++) {
            LadderLine ladderLine = strategy.executeHolizontalStrategy(playerCount);
            ladderLines.add(ladderLine);
        }
        return ladderLines;
    }

    private static LadderLine getLadderLine(Count count) {
        List<Point> points = new ArrayList<>();

        Point point = getFirstPoint(points);
        points.addAll(getMiddlePoints(count, point));
        Point beforeLastPoint = getBeforeLastPoint(points, count);
        addLastPoint(points, beforeLastPoint);
        return new LadderLine(points);
    }

    private static LadderLine getLadderLine2(Count count) {
        List<Point> points = new ArrayList<>();
        int end = count.getValue();

        for (int index = 0; index < end; index++) {
            addPoint(index, points);
        }
        return new LadderLine(points);
    }

    private static void addPoint(int index, List<Point> points) {
        if (index == 0) {
            addFirstPoint(points);
        }
        if (index == points.size()) {
//            points.add();
        }
    }

    private static void addFirstPoint(List<Point> points) {
        Point point = PointFactory.getFirstPoint();
        points.add(point);
    }

    private static Point getFirstPoint(List<Point> points) {
        Point point = PointFactory.getFirstPoint();
        points.add(point);
        return point;
    }

    private static List<Point> getMiddlePoints(Count count, Point point) {
        int end = count.getValue() - 1;
        List<Point> points = new ArrayList<>();
        for (int index = 1; index < end; index++) {
            point = point.next();
            points.add(point);
        }
        return points;
    }

    private static void addLastPoint(List<Point> points, Point point) {
        point = PointFactory.getLastPoint(point);
        points.add(point);
    }

    private static Point getBeforeLastPoint(List<Point> points, Count index) {
        int beforeLast = index.getValue() - BEFORE_LAST;
        return points.get(beforeLast);
    }
}
