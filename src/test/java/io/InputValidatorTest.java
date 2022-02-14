package io;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    InputValidator iv = new InputValidator();

    @Test
    @DisplayName("문자를 입력한 경우, 숫자를 입력해달라는 메시지를 담은 IAE")
    void positiveIntegerNotNumber() {
        assertThatThrownBy(() -> iv.positiveInteger("not number"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자를 입력해주세요.");
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
}
