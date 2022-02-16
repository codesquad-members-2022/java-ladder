import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;
    private int maxLength;

    private Line() {
    }

    public static Line createLineWithPlayerCount(int count) {
        Line line = new Line();
        line.maxLength = count;
        line.points = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            line.points.add(false);
        }
        return line;
    }

    public boolean isRadder(int radderPos) {
        checkPos(radderPos);
        return points.get(radderPos) && points.get(radderPos + 1);
    }

    private void checkPos(int point) {
        if (point < 0 || point >= maxLength - 1) {
            throw new IllegalArgumentException("pos가 정상 범위를 넘었습니다.");
        }
    }

    public void drawRadder(int radderPos) {
        checkPos(radderPos);
        points.set(radderPos, true);
        points.set(radderPos + 1, true);
    }

    public int getMaxLength() {
        return maxLength;
    }
}
