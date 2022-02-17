package ladder.domain.strategy;

import ladder.domain.DrawingStrategy;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.LadderLine;
import ladder.domain.ladder.Point;
import ladder.utils.Count;

import java.util.ArrayList;
import java.util.List;

public class LadderLineFactory {

    private static final int START = 0;
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

        Point point = PointFactory.getFirstPoint();
        points.add(point);
        points.addAll(getOtherPoints(count, point));
        return new LadderLine(points);
    }

    private static List<Point> getOtherPoints(Count count, Point point) {
        int start = 1;
        int end = count.getValue();
        List<Point> points = new ArrayList<>();

        for (int index = start; index < end; index++) {
            addPoint(index, end, point, points);
        }
        return points;
    }

    private static void addPoint(int index, int end, Point point, List<Point> points) {
        int beforeLast = end - 1;
        if (index == beforeLast) {
            point = PointFactory.getLastPoint(point);
            points.add(point);
            return;
        }
        point = point.next();
        points.add(point);
    }
}
