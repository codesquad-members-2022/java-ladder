package domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("정상적으로 동작하는(라인이 겹치지 않는) 사다리가 생성되는지 테스트")
    void createLadder() {
        Ladder ladder = new Ladder(11, 10);
        String overlappedLine = "|-----|-----|";
        System.out.println(ladder);
        Assertions.assertThat(ladder.toString()).doesNotContain(overlappedLine);
    }
}
