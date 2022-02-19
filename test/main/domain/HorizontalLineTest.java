package main.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HorizontalLineTest {
    @Test
    @DisplayName("겹치는 선이 존재하는지 테스트")
    void 겹치는_선_테스트() {
        // given
        int numOfPlayer = 30;
        HorizontalLine line = new HorizontalLine(numOfPlayer);
        List<Boolean> points = line.getPoints();
        boolean prev = false;

        // when
        for (boolean item : points) {
            if (prev) {
                // then
                assertEquals(false,item);
            }
            prev = item;
        }
    }
}