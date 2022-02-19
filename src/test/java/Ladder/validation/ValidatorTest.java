package Ladder.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Nested
    @DisplayName("입력한 이름들이 최소 1자리 이상 최대 5자리 이하를")
    class validateNameLengthTest {
        @Test
        @DisplayName("만족할 때 true를 리턴한다")
        void isNameMaxLengthFive_True_Test() {
            // given
            String playerNames = "park,kim,kang,aderp";

            // when
            boolean result = Validator.isNameMaxLengthFive(playerNames);

            // then
            assertTrue(result);
        }

        @Test
        @DisplayName("만족하지 않을 때 false를 리턴한다")
        void isNameMaxLengthFive_False_Test() {
            // given
            String playerNames = "park,,kang,aderpa";

            // when
            boolean result = Validator.isNameMaxLengthFive(playerNames);

            // then
            assertFalse(result);
        }
    }

}