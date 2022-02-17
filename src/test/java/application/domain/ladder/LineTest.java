package application.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static application.domain.element.LadderElement.*;
import static org.assertj.core.api.Assertions.*;

class LineTest {
    private Line line;

    @BeforeEach
    void beforeEach() {
        line = new Line();
    }

    @Test
    @DisplayName("현재 라인의 2번 째 요소가 'EMPTY' 일 때 3번 째 요소에 'RAIL' 을 append 한다.")
    void isValidTrue() {
        line.appendElement(STEP);
        line.appendElement(EMPTY);
        assertThat(line.isValid(2)).isTrue();
    }

    @Test
    @DisplayName("현재 라인의 2번 째 요소가 'STEP' 일 때 3번 째 요소에 'RAIL' 을 append 한다.")
    void isValidFalse() {
        line.appendElement(STEP);
        line.appendElement(STEP);
        assertThat(line.isValid(2)).isFalse();
    }
}