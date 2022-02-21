package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderLineTest {

    @Test
    @DisplayName("선분 그리기 테스트[성공]")
    void 라인_그리기_테스트_성공() {
        Point pointA = new Point(0, new Direction(false, true));
        Point pointB = pointA.next();
        Point pointC = pointB.next();
        Point pointD = pointC.last();

        List<Point> points = new ArrayList<>();
        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        points.add(pointD);

        LadderLine ladderLine = new LadderLine(points);
        assertThat(ladderLine).isNotNull();
    }

    @Test
    @DisplayName("선분 그리기 테스트[실패]")
    void 라인_그리기_테스트_실패() {
        assertThrows(IllegalStateException.class, () -> new Point(0, new Direction(true, true)));
    }


}