package ladder.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    void String_format메서드() {
        String name1 = "honux";
        String name2 = "crong";
        assertThat(String.format("%6s %6s", name1, name2)).isEqualTo(" honux  crong");
        assertThat(String.format("%10d%10d", 12345, 67890)).isEqualTo("     12345     67890");
        assertThat(String.format("%-10d%-10d", 12345, 67890)).isEqualTo("12345     67890     ");
    }

    @Test
    void 문자열_중앙정렬_초과시_점점표시() {
        String name = "honux";
        String overName = "hoooooooooooooooooooonux";

        assertThat(StringUtils.center("a", 5, ' ')).isEqualTo("  a  ");
        assertThat(StringUtils.center("aa", 5, ' ')).isEqualTo(" aa  ");
        assertThat(StringUtils.center("aaa", 5, ' ')).isEqualTo(" aaa ");
        assertThat(StringUtils.center("aaaa", 5, ' ')).isEqualTo("aaaa ");
        assertThat(StringUtils.center("aaaaa", 5, ' ')).isEqualTo("aaaaa");
        assertThat(StringUtils.center("aaaaaa", 5, ' ')).isEqualTo("aaa..");
        assertThat(StringUtils.center("aaaaaaa", 5, ' ')).isEqualTo("aaa..");
        assertThat(StringUtils.center(name, 10, ' ')).isEqualTo("  honux   ");
        assertThat(StringUtils.center(overName, 10, ' ')).isEqualTo("hooooooo..");

    }
}
