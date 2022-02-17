import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    @DisplayName("Ladder에 유효하지 않은 유저값이 주어졌을 경우 예외를 던지는 테스트")
    void illegalUserInputInLadder() {
        assertThatThrownBy(()->new Ladder(Arrays.asList("cococococo","honux","pobi"), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("Ladder에 유효하지 않은 라인값이 주어졌을 경우 예외를 던지는 테스트")
    void illegalLineInputInLadder() {
        assertThatThrownBy(()->new Ladder(Arrays.asList("honux","pobi"), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 올바르지 않습니다.");
    }
}
