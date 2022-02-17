import ladder.domain.Line;
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
    }

    @Test()
    void 라인_3명_연속된_사다리_2개_불가능() {
        Line line = Line.createLineWithPlayerCount(3);

        line.drawLadder(0);
        line.drawLadder(1);

        assertThat(line.isLadder(0)).isTrue();
        assertThat(line.isLadder(1)).isFalse();
    }

    @Test()
    void 라인_5명_사다리_2개() {
        Line line = Line.createLineWithPlayerCount(5);

        line.drawLadder(0);
        line.drawLadder(0);
        line.drawLadder(2);

        assertThat(line.isLadder(0)).isTrue();
        assertThat(line.isLadder(1)).isFalse();
        assertThat(line.isLadder(2)).isTrue();
        assertThat(line.isLadder(3)).isFalse();
    }

    @Test()
    void 라인_5명_사다리_4개() {
        Line line = Line.createLineWithPlayerCount(5);

        line.drawLadder(0);
        line.drawLadder(1);
        line.drawLadder(2);
        line.drawLadder(3);

        assertThat(line.isLadder(0)).isTrue();
        assertThat(line.isLadder(1)).isFalse();
        assertThat(line.isLadder(2)).isTrue();
        assertThat(line.isLadder(3)).isFalse();
    }

    @Test()
    void 라인_7명_사다리_2개() {
        Line line = Line.createLineWithPlayerCount(7);

        line.drawLadder(3);
        line.drawLadder(0);

        assertThat(line.isLadder(0)).isTrue();
        assertThat(line.isLadder(1)).isFalse();
        assertThat(line.isLadder(2)).isFalse();
        assertThat(line.isLadder(3)).isTrue();
        assertThat(line.isLadder(4)).isFalse();
        assertThat(line.isLadder(5)).isFalse();
    }
}