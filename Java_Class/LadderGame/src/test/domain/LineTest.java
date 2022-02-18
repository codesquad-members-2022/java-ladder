package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class LineTest {

    @Test
    @DisplayName("연속되는 사다리가 없는지 확인")
    void checkForAdjacentHorizontalLines() {
        //given
        int width = 500;
        String notAllowed = Line.HORIZONTAL + Line.VERTICAL + Line.HORIZONTAL;

        //when
        Line line = new Line(width);

        //then
        assertThat(line.getLine()).isNotEmpty();
        assertThat(line.getLine()).doesNotContain(notAllowed);
    }

    @Test
    @DisplayName("LineTest가 잘 되고 있는건지 확인")
    void control() {
        //given
        int width = 500;
        String notPossible = Line.HORIZONTAL + Line.HORIZONTAL;

        //when
        Line line = new Line(width);

        //then
        assertThat(line.getLine()).doesNotContain(notPossible);
    }
}