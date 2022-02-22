package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LineTest {

    @DisplayName("Line의 초기화값인 유저수가 8로 주어졌을 때, 좌표값인 Boolean은 랜덤으로 초기화되서 다르다,그리고 사이즈는 같다.")
    @Test
    void getPoints() {
        // given
        int userNumber = 8;
        Line sample1 = new Line(userNumber);
        Line sample2 = new Line(userNumber);

        // when
        ArrayList<Boolean> result1 = sample1.getPoints();
        ArrayList<Boolean> result2 = sample2.getPoints();

        // then
        Assertions.assertNotEquals(result1, result2);
        Assertions.assertEquals(result1.size(), result2.size());
    }
}