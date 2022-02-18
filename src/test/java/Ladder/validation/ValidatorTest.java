package Ladder.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("사용자가 입력한 이름들이 최소 1자리 이상 최대 5자리를 만족할 때")
    void isNameMaxLengthFiveTest1() {
        // given
        String playerNames = "park,kim,kang,aderp";

        // when
        boolean result = Validator.isNameMaxLengthFive(playerNames);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("사용자가 입력한 이름들이 최소 1자리 이상 최대 5자리를 만족하지 않을 때")
    void isNameMaxLengthFiveTest2() {
        // given
        String playerNames = "park,,kang,aderpa";

        // when
        boolean result = Validator.isNameMaxLengthFive(playerNames);

        // then
        assertFalse(result);
    }
}