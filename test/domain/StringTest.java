package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Formatter 객체 Test")
class StringTest {
    private static final int WIDTH = 5;

    @DisplayName("이름의 길이가 5글자 이내일 때 Padding 처리가 잘 되는가")
    @Test
    void testLessThanFiveLetters() {
        assertEquals(WIDTH, Formatter.checkAndPadding("a", WIDTH).length());
        assertEquals(WIDTH, Formatter.checkAndPadding("ab", WIDTH).length());
        assertEquals(WIDTH, Formatter.checkAndPadding("abc", WIDTH).length());
        assertEquals(WIDTH, Formatter.checkAndPadding("abcd", WIDTH).length());
    }

    @DisplayName("이름의 길이가 5글자 이상일 때 ..으로 줄여서 나오는가")
    @Test
    void testMoreThanFiveLetters(){
        assertEquals(WIDTH, Formatter.checkAndPadding("abcde", WIDTH).length());
        assertEquals(WIDTH, Formatter.checkAndPadding("abcdef", WIDTH).length());
        assertEquals(WIDTH, Formatter.checkAndPadding("abcdefg", WIDTH).length());
        assertEquals(WIDTH, Formatter.checkAndPadding("abcdefgh", WIDTH).length());
        assertEquals(WIDTH, Formatter.checkAndPadding("abcdefghi", WIDTH).length());
        assertEquals(WIDTH, Formatter.checkAndPadding("abcdefghij", WIDTH).length());
        assertEquals(WIDTH, Formatter.checkAndPadding("abcdefghijk", WIDTH).length());
    }

}