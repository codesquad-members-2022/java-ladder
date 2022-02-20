package app.jinan159.ladder.validation;

import app.jinan159.ladder.config.GameConfig;
import app.jinan159.ladder.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class InputValidatorTest {

    @Nested
    @DisplayName("validateIsPositive 메소드는")
    class ValidateIsPositiveTest{
        @Test
        @DisplayName("음수를 넣으면 IllegalArgumentException 예외가 발생한다.")
        void negativeNumberWillBeFail() {
            // given
            InputValidator validator = InputValidator.createWithConfig(null);

            // then
            assertThrows(IllegalArgumentException.class, () -> validator.validateIsPositive(-1));
        }

        @Test
        @DisplayName("0을 넣으면 IllegalArgumentException 예외가 발생한다.")
        void zeroWillBeFail() {
            // given
            InputValidator validator = InputValidator.createWithConfig(null);

            // then
            assertThrows(IllegalArgumentException.class, () -> validator.validateIsPositive(0));
        }

        @Test
        @DisplayName("양수를 넣으면 아무일도 일어나지 않는다.")
        void positiveNumberWillBeSuccess() {
            // given
            InputValidator validator = InputValidator.createWithConfig(null);

            // then
            try {
                validator.validateIsPositive(1);
            } catch (Exception e) {
                fail();
            }
        }
    }

    @Nested
    @DisplayName("validateNames 메소드는")
    class ValidateNamesTest{
        @Test
        @DisplayName("names 가 빈 배열이면 아무일도 일어나지 않는다.")
        void emptyArraySuccess() {
            // given
            GameConfig config = GameConfig.createWithNameLength(5);
            InputValidator validator = InputValidator.createWithConfig(config);
            String[] names = {};

            // then
            try {
                validator.validateNames(names);
            } catch (Exception e) {
                fail();
            }
        }

        @Test
        @DisplayName("names 가 null 이면 IllegalArgumentException 예외가 발생한다.")
        void validateSuccess() {
            // given
            GameConfig config = GameConfig.createWithNameLength(5);
            InputValidator validator = InputValidator.createWithConfig(config);

            // then
            assertThrows(IllegalArgumentException.class, () -> validator.validateNames(null));
        }

        @Test
        @DisplayName("이름 길이 설정이 5이고, 배열의 모든 요소가 5 이하면 성공한다.")
        void arrayValidateSuccess() {
            // given
            GameConfig config = GameConfig.createWithNameLength(5);
            InputValidator validator = InputValidator.createWithConfig(config);
            String[] names = {"", "a", "abcde"};

            // then
            try {
                validator.validateNames(names);
            } catch (Exception e) {
                fail();
            }
        }

        @Test
        @DisplayName("이름 길이 설정이 5이고, 배열의 모든 요소중 하나만 5 이상이어도 IllegalArgumentException 예외가 발생한다.")
        void arrayValidateFailed() {
            // given
            GameConfig config = GameConfig.createWithNameLength(5);
            InputValidator validator = InputValidator.createWithConfig(config);
            String[] names = {"", "a", "abcde", "123456"};

            // then
            assertThrows(IllegalArgumentException.class, () -> validator.validateNames(names));
        }
    }

}