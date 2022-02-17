import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("문자열 길이 구하기")
    void string_length() {
        String name = "루시드";
        assertThat(name.length()).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 더하기")
    void string_add() {
        String name = "루시드";
        String welcome = "안녕!";
        assertThat(name + welcome).isEqualTo("루시드안녕!");
    }


    @Test
    @DisplayName("문자열을 문자 단위로 출력")
    void string_to_charArray() {
        String name = "루시드";
    }

    @Test
    @DisplayName("문자열_뒤집기")
    void reverse_string() {
        String name = "루시드";
        StringBuilder sb = new StringBuilder(name);

        assertThat(sb.reverse().toString()).isEqualTo("드시루");
    }
}
