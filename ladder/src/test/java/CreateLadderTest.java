import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Line;

class CreateLadderTest {

    @Test
    @DisplayName("사다리 라인 단순생성 테스트")
    void createLadderLineTest() {
        String testLine = "|-----|";
        String testLine2 = "|-----|-----|";
        String testLine3 = "|-----|-----|-----|";
        Line line = new Line(2);
        Line line2 = new Line(3);
        Line line3 = new Line(4);
        assertThat(testLine).isEqualTo(line.printLine());
        assertThat(testLine2).isEqualTo(line2.printLine());
        assertThat(testLine3).isEqualTo(line3.printLine());
    }
}
