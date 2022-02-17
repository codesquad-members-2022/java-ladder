package ladder.test;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {
    @DisplayName("사다리 선 출력 가능 여부 테스트")
    @Test
    void getLadderLine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Line line = new Line();
        Method method = line.getClass().getDeclaredMethod("getLadderLine");
        String expectValue = "-----";

        // when
        String actualValue = (String) method.invoke(line);

        // then
        assertThat(actualValue).isEqualTo(expectValue);
    }
}
