package domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineCreateTest {

    Line line;

    @BeforeEach
    void init(){
        line = new Line(4);
    }

    @Test
    void createTest(){
        assertThat(line.length()).isEqualTo(4);
    }

    @Test
    void invalidInputTest(){
        assertThatThrownBy(() -> new Line(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Line(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void drawLadderTest(){
        // 1 1 0 0
        boolean result = line.makeLadderAt(0);
        assertThat(result).isTrue();
        assertThat(line.isMarkedPosition(0)).isTrue();
        assertThat(line.isMarkedPosition(1)).isTrue();
    }

    @Test
    @DisplayName("이미 마킹된곳에 시도해보기")
    void already_marked_position_create_ladder(){
        // 0 1 1 0
        assertThat(line.makeLadderAt(1)).isTrue();
        assertThatThrownBy(() -> line.makeLadderAt(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> line.makeLadderAt(2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void draw_ladder_invalid_inputTest(){
        assertThatThrownBy(() -> line.makeLadderAt(4)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> line.makeLadderAt(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 라인_없는경우_방향전환_테스트(){
        assertThat(line.switchLadderLine(0)).isEqualTo(0);
        assertThat(line.switchLadderLine(3)).isEqualTo(3);
    }

    @Test
    public void 왼쪽으로_이동_테스트() {
        // given : 0 1 1 0
        assertThat(line.makeLadderAt(1)).isTrue();

        // when
        int result = line.switchLadderLine(2);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 오른쪽으로_이동_테스트() {
        // given : 0 0 1 1
        assertThat(line.makeLadderAt(2)).isTrue();

        // when
        int result = line.switchLadderLine(3);

        // then
        assertThat(result).isEqualTo(2);
    }

    @AfterEach
    void tearDown() {
        line = null;
    }
}
