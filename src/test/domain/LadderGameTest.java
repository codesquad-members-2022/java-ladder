package test.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import main.domain.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    private static final int WRAPPER_LENGTH = 5;

    @Test
    @DisplayName("이름 테스트 - 길이 0")
    public void nameTest_0() {

        String name = "";  // 글자수 0

        LadderGame game = new LadderGame(List.of(), 0);
        String wrapper = game.wrapName(name);

        assertEquals(wrapper.length(), WRAPPER_LENGTH);
        assertEquals(wrapper.strip(), name);
    }


    @Test
    @DisplayName("이름 테스트 - 길이 1")
    public void nameTest_1() {

        String name = "A";  // 글자수 1

        LadderGame game = new LadderGame(List.of(), 0);
        String wrapper = game.wrapName(name);

        assertEquals(wrapper.length(), WRAPPER_LENGTH);
        assertEquals(wrapper.strip(), name);
    }

    @Test
    @DisplayName("이름 테스트 - 길이 2")
    public void nameTest_2() {

        String name = "AB";  // 글자수 2

        LadderGame game = new LadderGame(List.of(), 0);
        String wrapper = game.wrapName(name);

        assertEquals(wrapper.length(), WRAPPER_LENGTH);
        assertEquals(wrapper.strip(), name);
    }

    @Test
    @DisplayName("이름 테스트 - 길이 3")
    public void nameTest_3() {

        String name = "ABC";  // 글자수 3

        LadderGame game = new LadderGame(List.of(), 0);
        String wrapper = game.wrapName(name);

        assertEquals(wrapper.length(), WRAPPER_LENGTH);
        assertEquals(wrapper.strip(), name);
    }

    @Test
    @DisplayName("이름 테스트 - 길이 4")
    public void nameTest_4() {

        String name = "ABCD";  // 글자수 4

        LadderGame game = new LadderGame(List.of(), 0);
        String wrapper = game.wrapName(name);

        assertEquals(wrapper.length(), WRAPPER_LENGTH);
        assertEquals(wrapper.strip(), name);
    }

    @Test
    @DisplayName("이름 테스트 - 길이 5")
    public void nameTest_5() {

        String name = "ABCDE";  // 글자수 5

        LadderGame game = new LadderGame(List.of(), 0);
        String wrapper = game.wrapName(name);

        assertEquals(wrapper.length(), WRAPPER_LENGTH);
        assertEquals(wrapper.strip(), name);
    }

    @Test
    @DisplayName("이름 테스트 - 길이 6")
    public void nameTest_6() {

        String name = "ABCDEF";  // 글자수 6

        LadderGame game = new LadderGame(List.of(), 0);

        assertThrows(IllegalArgumentException.class, () -> game.wrapName(name));
    }

}
