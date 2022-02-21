package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameFormatTest {
    @ParameterizedTest
    @DisplayName("모든 이름은 공백 포함 6자를 만들어낸다.")
    @ValueSource(strings = {"a", "ap", "val", "ball", "lucid"})
    void name_format_test_o(String name) {
        NameFormat formatter = NameFormat.getFormatter(name.length());
        assertThat(formatter.makeForm(name).length()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("5자 이상의 이름은 예외가 발생한다.")
    @ValueSource(strings = {"lucidd", "adsfdff", "adfasdfasdf", "adsfsadffd"})
    void name_format_test_x(String name) {
        Assertions.assertThrows(NullPointerException.class, () -> {
            NameFormat.getFormatter(name.length());
        });
    }
}