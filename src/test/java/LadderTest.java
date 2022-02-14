import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    @DisplayName("Ladder 생성 테스트")
    void createLadder() {
        int n = 3;
        int m = 5;

        Ladder ladder = new Ladder(n, m);
        System.out.println(ladder.toString());

        assertThat(ladder.getLadderWidth()).isEqualTo(5);
        assertThat(ladder.getLadderHeight()).isEqualTo(5);
    }

    @Test
    @DisplayName("Ladder에 유효하지 않은 유저값이 주어졌을 경우 예외를 던지는 테스트")
    void illegalUserInputInLadder() {
        assertThatThrownBy(()->new Ladder(1, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("Ladder에 유효하지 않은 라인값이 주어졌을 경우 예외를 던지는 테스트")
    void illegalLineInputInLadder() {
        assertThatThrownBy(()->new Ladder(3, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 올바르지 않습니다.");
    }
}
