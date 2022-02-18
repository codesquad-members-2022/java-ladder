package domain.ladder;

import domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리 생성하여 찍어보기")
    void createLadder() {
        Ladder ladder = new Ladder(3, 5);
        System.out.println(ladder);
    }
}
