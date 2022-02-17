
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class StringBuilderTest {
    @Test
    public void append() {
        assertThat(createMessage(14)).isEqualTo("코드스쿼드 백엔드 수강생은? 14 명이다.");
    }

    private String createMessage(int numberOfClass) {
        StringBuilder sb = new StringBuilder();
        // TODO append() 메소드 활용해 요구사항 구현
        sb.append("코드스쿼드 ")
            .append("백엔드 ")
            .append("수강생은? ")
            .append(numberOfClass)
            .append(" 명이다.");

        return sb.toString();
    }
}