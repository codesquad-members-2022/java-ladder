package domain;

import domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("Line 생성 시 중복 줄이 없는지 테스트")
    void createLine() {
        Line line = Line.createRandomStep(100);

        assertThat(line.toString().contains("-----|-----")).isFalse();

    }
}
