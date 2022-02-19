package ladder.test;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {
    @DisplayName("사다리 선 출력 가능 여부 테스트")
    @Test
    void getLadderLine() {
        // given
        int testPlayerCount = 4;

        // when
        Line line = new Line(testPlayerCount);

        // then
        boolean result = line.getPoints().stream().anyMatch(v -> v == true);
        assertThat(result).isTrue();
    }
}
