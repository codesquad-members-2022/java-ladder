import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Line;

class CreateLadderTest {

    @Test
    @DisplayName("사다리 라인 생성 테스트")
    void createLadderLineTest() {
        String testLine = "|-----|-----|";
        for (int i = 0; i < 50; i++) {
            Line line = new Line(3);
            assertThat(testLine).isNotEqualTo(line.toString());
        }
    }
}
