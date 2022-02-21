package domain;

import domain.ladder.UserDefineLadder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDefineLadderTest {
    @Test
    public void 라인_없을경우_테스트() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(1, 5);

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
        UserDefineLadder ladder = new UserDefineLadder(1, 5);
        // 1 1 0 0 0
        ladder.makeLadderAt(0, 0);

        // when
        int result = ladder.run(1);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 라인_있을때_맨처음지점에서_시작_테스트() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(1, 5);
        // 1 1 0 0 0
        ladder.makeLadderAt(0, 0);

        // when
        int result = ladder.run(0);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 라인_있을때_우측으로_이동_테스트() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(1, 5);
        // 0 1 1 0 0
        ladder.makeLadderAt(0, 1);

        // when
        int result = ladder.run(1);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 라인_있을때_맨끝지점에서_시작_테스트() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(1, 5);
        // 0 0 0 1 1
        ladder.makeLadderAt(0, 3);

        // when
        int result = ladder.run(4);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 여러_라인_있을때_테스트() {
        // given
        UserDefineLadder ladder = new UserDefineLadder(3, 5);
        // 1 1 0 0 0
        // 0 1 1 0 0
        // 0 0 1 1 0
        ladder.makeLadderAt(0, 0);
        ladder.makeLadderAt(1, 1);
        ladder.makeLadderAt(2, 2);

        // when
        int result1 = ladder.run(0);
        int result2 = ladder.run(1);
        int result3 = ladder.run(2);
        int result4 = ladder.run(3);
        int result5 = ladder.run(4);

        // then
        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(1);
        assertThat(result4).isEqualTo(2);
        assertThat(result5).isEqualTo(4);
    }
}
