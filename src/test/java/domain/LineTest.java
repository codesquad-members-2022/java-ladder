package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

    Line line;

    @BeforeEach
    void beforeEach() {
        line = new Line(10);
    }

    @ParameterizedTest
    @DisplayName("사람 수 - 1 크기의 boolean 리스트를 가지게 된다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    void make_line_o(int idx) {
        assertThat(line.putLine(idx)).isInstanceOf(Boolean.class);
    }

    @ParameterizedTest
    @DisplayName("범위를 넘어선 인덱스를 요청하면 예외가 발생한다.")
    @ValueSource(ints = {9, 10, 11, 12, 100})
    void make_line_x(int idx) {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            line.putLine(idx);
        });
    }

}