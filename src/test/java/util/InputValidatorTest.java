package util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    InputValidator iv = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 문자열 또는 공백를 입력한 경우, 값을 입력해달라는 메시지를 담은 IAE")
    void positiveIntegerEmptyOrBlank(String input) {
        assertThatThrownBy(() -> iv.positiveInteger(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"not number", "1.23"})
    @DisplayName("0~9 외의 문자가 포함된 문자열을 입력한 경우, 숫자를 입력해달라는 메시지를 담은 IAE")
    void positiveIntegerNotNumber(String input) {
        assertThatThrownBy(() -> iv.positiveInteger(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자(정수)를 입력해주세요.");
    }

    @Test
    @DisplayName("int 범위를 초과한 값을 입력한 경우, 범위를 초과했다는 메시지를 담은 IAE")
    void positiveIntegerNotInteger() {
        assertThatThrownBy(() -> iv.positiveInteger("123456789123456789"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("int 범위를 초과합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    @DisplayName("음수 또는 0을 입력한 경우, 양수를 입력해달라는 메시지를 담은 IAE")
    void positiveIntegerNotPositiveNumber(String input) {
        assertThatThrownBy(() -> iv.positiveInteger(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("양수를 입력해주세요.");
    }

    @Test
    @DisplayName("범위내(1~Integer.MAX_VALUE)의 숫자를 입력한 경우, 문자열을 정수로 변환하여 리턴")
    void positiveIntegerPositiveNumber() {
        assertThat(iv.positiveInteger("50")).isEqualTo(50);
    }

    @Test
    @DisplayName("이름을 쉼표로 구분하여 입력하면, split한 결과를 리턴")
    void names_O() {
        String[] names = iv.names("pobi, honux, crong, jk");
        String[] expected = {"pobi", "honux", "crong", "jk"};
        assertThat(names).containsExactly(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi honux crong jk", "pobi, "})
    @DisplayName("이름을 쉼표로 구분하여 2명 이하일 때, IAE")
    void names_X(String input) {
        assertThatThrownBy(() -> iv.names(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름을 쉼표로 구분하여 2명 이상 입력해주세요.");
    }
}
