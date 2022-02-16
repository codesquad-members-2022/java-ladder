import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 라인_3명_초기값_사다리없음() {
        Line line = Line.createLineWithPlayerCount(3);

        assertThat(line.isLadder(0)).isFalse();
        assertThat(line.isLadder(1)).isFalse();
    }

    @Test()
    void 라인_3명_사다리_1개() {
        Line line = Line.createLineWithPlayerCount(3);

        line.drawLadder(0);

        assertThat(line.isLadder(0)).isTrue();
        assertThat(line.isLadder(1)).isFalse();
    }

    @Test()
    void 라인_3명_사다리_2개() {
        Line line = Line.createLineWithPlayerCount(3);

        line.drawLadder(0);
        line.drawLadder(1);

        assertThat(line.isLadder(0)).isTrue();
        assertThat(line.isLadder(1)).isTrue();
    }
}