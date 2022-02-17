package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void arrayList() throws Exception {
        LinkedList<String> values = new LinkedList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가하라.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구하라.
        assertThat(values.getFirst()).isEqualTo("first"); // 첫 번째 값을 찾아라.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인해라.
        assertThat(values.removeFirst()).isEqualTo("first"); // 첫 번째 값을 삭제해라.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        System.out.println(values);
    }
}
