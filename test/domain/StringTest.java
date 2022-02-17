package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Formatter 객체 Test")
class StringTest {
    private static final int WIDTH = 5;

    @DisplayName("이름이 총 5글자로 리턴되는가")
    @Test
    void testFiveLetters() {
        assertEquals(5, Formatter.checkAndPadding("a", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("ab", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("abc", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("abcd", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("abcde", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("abcdef", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("abcdefg", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("abcdefgh", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("abcdefghi", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("abcdefghij", WIDTH).length());
        assertEquals(5, Formatter.checkAndPadding("abcdefghijk", WIDTH).length());

    }
}