package ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StringUtils 클래스")
class StringUtilsTest {

    @Nested
    @DisplayName("center 메소드는")
    class Describe_center {

        @Nested
        @DisplayName("만약 legnth이 str length보다 크고 pad 문자가 ' ' 이라면")
        class Context_with_length_greater_than_str_length_and_pad_space {

            @Test
            @DisplayName("pad로 채워진 문자를 리턴한다.")
            void it_returns_str() {
                assertThat(StringUtils.center("a", 5, ' ')).isEqualTo("  a  ");
                assertThat(StringUtils.center("aa", 5, ' ')).isEqualTo(" aa  ");
                assertThat(StringUtils.center("aaa", 5, ' ')).isEqualTo(" aaa ");
                assertThat(StringUtils.center("aaaa", 5, ' ')).isEqualTo("aaaa ");
                assertThat(StringUtils.center("honux", 10, ' ')).isEqualTo("  honux   ");
            }
        }

        @Nested
        @DisplayName("만약 legnth이 str length보다 작다면")
        class Context_with_length_less_than_str_length {
            @Test
            @DisplayName("str 그대로 리턴한다.")
            void it_returns_str() {
                assertThat(StringUtils.center("aaaaaa", 2, ' ')).isEqualTo("aaaaaa");
                assertThat(StringUtils.center("aaaaaa", 5, ' ')).isEqualTo("aaaaaa");
                assertThat(StringUtils.center("aaaaabbbbbb", 5, ' ')).isEqualTo("aaaaabbbbbb");
                assertThat(StringUtils.center("hoooooooooooooooooooonux", 10, ' ')).isEqualTo("hoooooooooooooooooooonux");
            }
        }
    }

    @Nested
    @DisplayName("withLimitLength 메소드는")
    class Describe_withLimitLength {

        @Nested
        @DisplayName("만약 문자열 크기가 limit lenght 보다 작다면")
        class Context_with_str_size_less_than_limit_length {

            @Test
            @DisplayName("문자열 그대로 리턴한다.")
            void it_returns_a_string() {
                assertThat(StringUtils.withLimitLength("012345", 10)).isEqualTo("012345");
                assertThat(StringUtils.withLimitLength("0123456789", 10)).isEqualTo("0123456789");
            }
        }


        @Nested
        @DisplayName("만약 문자열이 limit lenght 보다 크다면")
        class Context_with_str_size_greater_than_limit_length {

            @Test
            @DisplayName("limit length 만큼 문자를 자르고 뒤에 ..을 붙인 문자열을 리턴한다.")
            void it_returns_a_string() {
                assertThat(StringUtils.withLimitLength("Kuuuuuuuuuuukim", 5)).isEqualTo("Kuu..");
                assertThat(StringUtils.withLimitLength("Hoooooooooooooooooonux", 10)).isEqualTo("Hooooooo..");
            }
        }
    }

}
