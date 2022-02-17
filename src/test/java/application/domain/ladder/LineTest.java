package application.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
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
    void isValidTrue() {
        line.appendElement(STEP);
        line.appendElement(EMPTY);
        assertThat(line.isValid(2)).isTrue();
    }

    @Test
    void isValidFalse() {
        line.appendElement(STEP);
        line.appendElement(STEP);
        assertThat(line.isValid(2)).isFalse();
    }
}