package app.jinan159.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Nested
    @DisplayName("padLeftRightTest 메소드는")
    class PadLeftRightTest {
        @Test
        @DisplayName("source 가 'str' 이고 길이가 5면 ' str ' 를 반환한다.")
        void samePaddingLeftRight() {
            // given
            int count = 5;
            String source = "str";
            String expected = " str ";

            // when
            String result = StringUtils.padLeftRight(source, count);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("source 가 'str' 이고 길이가 4면 ' str' 를 반환한다.")
        void padOnlyLeft() {
            // given
            int count = 4;
            String source = "str";
            String expected = " str";

            // when
            String result = StringUtils.padLeftRight(source, count);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("source로 null이 주어지면 IllegalArgumentException 예외가 발생한다")
        void nullSourceReturnEmpty() {
            // given
            int count = 5;
            String source = null;

            // then
            assertThrows(IllegalArgumentException.class, () -> StringUtils.padLeftRight(source, count));
        }

        @Test
        @DisplayName("source 보다 totalSize 의 길이가 작으면 IllegalArgumentException 예외가 발생한다.")
        void countIsLessThanSource() {
            // given
            int count = 1;
            String source = "str";

            // then
            assertThrows(IllegalArgumentException.class, () -> StringUtils.padLeftRight(source, count));
        }
    }

    @Nested
    @DisplayName("repeatCharacter 메소드는")
    class RepeatCharacterTest {
        @Test
        @DisplayName(" 공백(' ') 과 5가 주어지면 5개의 공백을 반환한다. ")
        void successTest() {
            // given
            char empty = ' ';
            int count = 5;
            String expected = " ".repeat(count);

            // when
            String result = StringUtils.repeatCharacter(empty, count);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("개수가 음수가 주어지면 IllegalArgumentException 예외가 발생한다.")
        void negativeNumberTest() {
            // given
            char empty = ' ';
            int count = -1;

            // then
            assertThrows(IllegalArgumentException.class, () -> StringUtils.repeatCharacter(empty, count));
        }
    }

}