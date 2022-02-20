package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class StringTest {
    @Test
    public void 문자열_길이_구하기() throws Exception {
        String name = "박재성";
        assertThat(name.length()).isEqualTo(3);
    }

    @Test
    public void 문자열_더하기() throws Exception {
        String name = "박재성";
        String welcome = "안녕!";
        assertThat(welcome+name).isEqualTo("안녕!박재성");
    }

    @Test
    public void 문자열을_문자_단위로_출력() throws Exception {
        String name = "박재성";
        // String의 각 문자를 배열로 가져올 수 있는 API 활용해 구현 가능
        for (char c : name.toCharArray()) {
            System.out.println(c);
        }
    }

    @Test
    public void 문자열_뒤집기() throws Exception {
        String name = "박재성";
        StringBuilder sb = new StringBuilder();
        // String의 각 문자를 배열로 가져올 수 있는 API 활용해 구현 가능
        for (int i = name.length()-1; i >= 0; i--) {
            sb.append(name.charAt(i));
        }
        assertThat(sb.toString()).isEqualTo("성재박");
    }
}

