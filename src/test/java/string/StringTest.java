package string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
        assertThat(welcome.concat(name)).isEqualTo("안녕!박재성");
    }

    @Test
    public void 문자열을_문자_단위로_출력() throws Exception {
        String name = "박재성";
        for (char ch : name.toCharArray()) {
            System.out.println(ch);
        }
    }

    @Test
    public void 문자열_뒤집기() throws Exception {
        String name = "박재성";

        String reverseName = "";
        char[] charArray = name.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            reverseName += (charArray[i]);
        }

        assertThat(reverseName).isEqualTo("성재박");
    }
}
