package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리가 제대로 그려지는지 출력해서 확인")
    void render() {
        System.out.println(new Ladder(10, 10).render());
    }
}
