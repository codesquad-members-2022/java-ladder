package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {

    Line line;

    @BeforeEach
    void beforeEach() {
        line = new Line();
    }

    @ParameterizedTest
    @DisplayName("이전에 발판이 없고(:true), 랜덤 값도 true일 경우에 발판이 생성된다.")
    @CsvSource("{true, true}, {false, false}")
    void before_line_is_empty(boolean randomValue, boolean result) {
        line.addLine(randomValue);
        boolean target = line.canPutLine(0);
        assertThat(target).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("이전에 발판이 있는 경우(:false)에는 랜덤 값에 상관 없이 발판이 생성되지 않는다")
    @CsvSource("{true, false}, {false, false}")
    void before_line_is_filled(boolean randomValue, boolean result) {
        line.addLine(true);
        line.addLine(randomValue);
        boolean target = line.canPutLine(1);
        assertThat(target).isEqualTo(result);
    }
}