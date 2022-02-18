package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class LineTest {

    @Test
    @DisplayName("연속되는 사다리가 없는지 확인")
    void checkAdjacentHorizontalLines() {
        //given
        int width = 500;
        String notAllowed = Line.HORIZONTAL + Line.VERTICAL + Line.HORIZONTAL;

        //when
        Line line = new Line(width);

        //then
        assertThat(line.getLine().contains(notAllowed)).isFalse();
    }

    @Test
    @DisplayName("사다리 테스트가 잘 되고 있는건지 확인")
    void checkForBrokenLadders() {
        //given
        int width = 500;
        String notAllowed = Line.HORIZONTAL + Line.HORIZONTAL;

        //when
        Line line = new Line(width);

        //then
        assertThat(line.getLine().contains(notAllowed)).isFalse();
    }
}