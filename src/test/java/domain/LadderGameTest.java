package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void test() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(5);

        // when
        int result = ladder.run(0);
        int result2 = ladder.run(4);

        // then
        assertThat(result).isEqualTo(0);
        assertThat(result2).isEqualTo(4);
    }
    
    @Test
    public void 라인_있을때_왼쪽으로_이동_테스트() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(5);
        // 1 1 0 0 0
        ladder.makeLadderAt(0);

        // when
        int result = ladder.run(1);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 라인_있을때_맨처음지점에서_시작_테스트() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(5);
        // 1 1 0 0 0
        ladder.makeLadderAt(0);

        // when
        int result = ladder.run(0);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 라인_있을때_우측으로_이동_테스트() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(5);
        // 0 1 1 0 0
        ladder.makeLadderAt(1);

        // when
        int result = ladder.run(1);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 라인_있을때_맨끝지점에서_시작_테스트() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(5);
        // 0 0 0 1 1
        ladder.makeLadderAt(3);

        // when
        int result = ladder.run(4);

        // then
        assertThat(result).isEqualTo(3);
    }
}
