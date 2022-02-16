import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 라인_3명_초기값_사다리없음() {
        Line line = Line.createLineWithPlayerCount(3);

        assertThat(line.isRadder(0)).isFalse();
        assertThat(line.isRadder(1)).isFalse();
    }

    @Test()
    void 라인_3명_사다리_1개() {
        Line line = Line.createLineWithPlayerCount(3);

        line.drawRadder(0);

        assertThat(line.isRadder(0)).isTrue();
        assertThat(line.isRadder(1)).isFalse();
    }

    @Test()
    void 라인_3명_사다리_2개() {
        Line line = Line.createLineWithPlayerCount(3);

        line.drawRadder(0);
        line.drawRadder(1);

        assertThat(line.isRadder(0)).isTrue();
        assertThat(line.isRadder(1)).isTrue();
    }
}