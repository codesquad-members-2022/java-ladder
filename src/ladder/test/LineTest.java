package ladder.test;

import ladder.domain.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LineTest {
    @Test
    void 선을_그리는_로직_테스트() {
        //given
        int countOfPlayer = 15;
        Line line = new Line(countOfPlayer);
        List<Boolean> points = line.getPoints();
        //when
        for (int i = 1; i < points.size(); i++) {
            if (Boolean.TRUE.equals(points.get(i - 1))) {
                //then
                Assertions.assertEquals(false, points.get(i));
            }
        }
    }
}
