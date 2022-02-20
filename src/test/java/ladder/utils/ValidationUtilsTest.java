package ladder.utils;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void validCoordinate() {
        assertThrows(IllegalArgumentException.class, () -> new Line(-1), "좌표의 값은 0 이상 이어야 합니다.");
    }

    @Test
    void validLadderHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(null, -1), "사다리 높이는 0 이상 이어야 합니다.");
    }

    @Test
    void validName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("123456"), "이름의 길이는 5글자가 넘을 수 없습니다.");
    }
}