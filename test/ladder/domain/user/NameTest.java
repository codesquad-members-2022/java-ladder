package ladder.domain.user;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NameTest {

    @Test
    @DisplayName("이름 길이 테스트[최대]")
    void 이름길이_테스트_최대() {
        assertThrows(IndexOutOfBoundsException.class, () -> new Name("LENGTH_OVER_FIVE"));
    }

    @Test
    @DisplayName("이름 길이 테스트[최소]")
    void 이름길이_테스트_최소() {
        assertThrows(IndexOutOfBoundsException.class, () -> new Name(""));
    }

    @Test
    @DisplayName("이름 길이 테스트[Null]")
    void 이름길이_테스트_Null() {
        assertThrows(NullPointerException.class, () -> new Name(null));
    }

    @Test
    @DisplayName("이름 길이 테스트[범위_내]")
    void 이름길이_테스트_범위_내() {
        int min = 1;
        int max = 5;

        for (int index = min; index <= max; index++) {
            assertTrue(min <= index && index <= max);
        }
    }
}