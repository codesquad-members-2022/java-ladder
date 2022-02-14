package string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringBuilderTest {

    @Test
    public void append() {
        assertThat(createMessage(14)).isEqualTo("코드스쿼드 백엔드 수강생은? 14 명이다.");
    }

    private String createMessage(int numberOfClass) {
        StringBuilder sb = new StringBuilder();
        sb.append("코드스쿼드 백엔드 수강생은? ")
            .append(numberOfClass)
            .append(" 명이다.");
        return sb.toString();
    }
}
